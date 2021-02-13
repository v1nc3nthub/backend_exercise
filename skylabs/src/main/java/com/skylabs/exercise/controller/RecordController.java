package com.skylabs.exercise.controller;

import com.skylabs.exercise.CustomPageRequest;
import com.skylabs.exercise.entities.FilterRecord;
import com.skylabs.exercise.entities.Record;
import com.skylabs.exercise.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@RestController
public class RecordController {

    @Autowired
    private RecordService service;
    @PersistenceContext
    private EntityManager em;

    @GetMapping("/records")
    public @ResponseBody Iterable<Record> list(
            @RequestParam(defaultValue = "10") Integer limit,
            @RequestParam(defaultValue = "0") Integer offset,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String sortDirection)
    {
        return service.findAll(new CustomPageRequest(offset, limit, Sort.by(Sort.Direction.fromString(sortDirection), sortBy))).getContent();
    }

    @GetMapping("/records/filtered")
    public @ResponseBody List<FilterRecord> listFiltered(
            @RequestParam(name = "aggregationType") String aggregationType,
            @RequestParam(name = "aggregationValue") Integer aggregationValue)
    {
        List<FilterRecord> filterRecords = new ArrayList<>();
        try {
            String sql = "SELECT ?1 as aggregation_type, ?2 as aggregation_value," +
                        "       SUM(r.capital_gain)*1.0 as capital_gain_sum, (SUM(capital_gain)/count(*))*1.0 as capital_gain_avg," +
                        "       SUM(r.capital_loss)*1.0 as capital_loss_sum, (SUM(capital_loss)/count(*))*1.0 as capital_loss_avg," +
                        "       r.over_50k as is_over50k, count(*) as count_50k " +
                        "FROM records r WHERE r." + aggregationType + " = ?2 GROUP BY r.over_50k";
            Query query = em.createNativeQuery(sql, FilterRecord.class);
            query.setParameter(1, aggregationType);
            query.setParameter(2, aggregationValue);
            filterRecords = (List<FilterRecord>) query.getResultList();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Unable aggregate data with aggregationType: "+aggregationType+" and aggregationValue: "+aggregationValue);
        }

        return filterRecords;
    }
}
