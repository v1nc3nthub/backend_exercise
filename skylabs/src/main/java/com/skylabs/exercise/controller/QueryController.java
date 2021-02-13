package com.skylabs.exercise.controller;

import com.skylabs.exercise.entities.Query;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@RestController
public class QueryController {

    private List<Query> queriesList;

    @PostConstruct
    private void init()
    {
        queriesList = new ArrayList<>();
        queriesList.add(new Query(1,
               "Scrivi una query che estragga il numero di persone con meno di 30 anni che guadagnano più di 50.000 dollari l'anno",
                "select count(*) from records where age < 30 and over_50k = 1;"));
        queriesList.add(new Query(2,
               "Scrivi una query che riporti il guadagno di capitale medio per ogni categoria lavorativa",
                "select w.name, (sum(r.capital_gain) - sum(r.capital_loss))/count(*) as capital_average " +
                            "from records r " +
                            "join workclasses w on w.id = r.workclass_id " +
                            "group by w.name " +
                            "order by capital_average asc;"));
    }

    @GetMapping("/exercise-query/{id}")
    public @ResponseBody Query getById(@PathVariable("id") Integer queryId)
    {
        if (queryId == null || (!queryId.equals(1) && !queryId.equals(2)))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Unable to found query for index");
        return queriesList.get(queryId-1);
    }

}
