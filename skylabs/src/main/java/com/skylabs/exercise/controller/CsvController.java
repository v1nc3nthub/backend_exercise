package com.skylabs.exercise.controller;

import com.skylabs.exercise.entities.*;
import com.skylabs.exercise.service.RecordService;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.QuoteMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;

import javax.ws.rs.core.HttpHeaders;
import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Controller
@RequestMapping(value = "/csv")
public class CsvController {

    @Autowired
    private RecordService service;

    @GetMapping("/download")
    public ResponseEntity<Resource> getFile() {
        String filename         = "records.csv";

        List<Record> recordList = null;
        try {
            Iterable<Record> recordIterable = service.findAll();
            recordList = StreamSupport.stream(recordIterable.spliterator(), false).collect(Collectors.toList());
        }catch (Exception e){
            e.printStackTrace();
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Unable to load records for csv");
        }

        InputStreamResource file = null;
        try{
            CSVFormat format            = CSVFormat.DEFAULT.withQuoteMode(QuoteMode.MINIMAL);
            ByteArrayOutputStream out   = new ByteArrayOutputStream();
            CSVPrinter csvPrinter       = new CSVPrinter(new PrintWriter(out), format);

            for(Record r : recordList){
                List<String> data = Arrays.asList(
                        String.valueOf(r.getId()),
                        String.valueOf(r.getAge()),
                        r.getWorkclass().toString(),
                        r.getEducationLevel().toString(),
                        r.getMaritalStatus().toString(),
                        r.getOccupation().toString(),
                        r.getRelationship().toString(),
                        r.getRace().toString(),
                        r.getSex().toString(),
                        String.valueOf(r.getCapitalGain()),
                        String.valueOf(r.getCapitalLoss()),
                        String.valueOf(r.getHoursWeek()),
                        r.getCountry().toString(),
                        String.valueOf(r.getOver50K())
                );
                csvPrinter.printRecord(data);
            }
            csvPrinter.flush();
            ByteArrayInputStream in = new ByteArrayInputStream(out.toByteArray());
            file = new InputStreamResource(in);

        }catch (IOException e){
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Unable to create records csv file");
        }

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
                .contentType(MediaType.parseMediaType("application/csv"))
                .body(file);
    }



}
