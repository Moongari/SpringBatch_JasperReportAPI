package com.moon.batchApi.personspringBatchApi.controller;


import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@ControllerAdvice
public class PersonnController {

    @Autowired
    private JobLauncher jobLauncher;
    @Autowired
    private Job job;




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








}
