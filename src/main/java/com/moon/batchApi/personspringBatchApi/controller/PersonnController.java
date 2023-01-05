package com.moon.batchApi.personspringBatchApi.controller;


import com.moon.batchApi.personspringBatchApi.Dao.PersonnRepository;
import com.moon.batchApi.personspringBatchApi.model.Personn;
import com.moon.batchApi.personspringBatchApi.service.ReportService;
import net.sf.jasperreports.engine.JRException;
import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@ControllerAdvice
public class PersonnController {

    @Autowired
    private JobLauncher jobLauncher;
    @Autowired
    private Job job;
    @Autowired
    private PersonnRepository personnRepository;
    @Autowired
    private ReportService reportService;

    @Value(value = "${data.exception.message1}")
    private String message1;
    @Value(value = "${data.exception.message2}")
    private String message2;


    @GetMapping("/startBatch")
    public BatchStatus load() throws Exception {

        Map<String, JobParameter> params = new HashMap<>();

        params.put("time",new JobParameter(System.currentTimeMillis()));
        JobParameters parameters = new JobParameters(params);

        JobExecution jobExecution = jobLauncher.run(job,parameters);

        while (jobExecution.isRunning()){
            System.out.println("......");
        }

        return jobExecution.getStatus();
    }

    @GetMapping("/allPersonn")
    public ResponseEntity<List<Personn>> getAllPersonn(){

        if(personnRepository.findAll().isEmpty()){

            return  new ResponseEntity(message1, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(personnRepository.findAll(), HttpStatus.OK);

    }

    @GetMapping("/report/{format}")
    public ResponseEntity<String> generateReport(@PathVariable String format) throws JRException, FileNotFoundException {

        if(format != null){
            return  new ResponseEntity<>(reportService.ExportReport( format),HttpStatus.OK);
        }else{
            return new ResponseEntity(message2,HttpStatus.BAD_REQUEST);
        }


    }








}
