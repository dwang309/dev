package com.dw.batch.person.controller;

import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("batch")
public class PersonJobInvokeController {

    @Autowired
    JobLauncher jobLauncher;

    @Autowired
    @Qualifier("importUserJob")
    Job importUserJob;

    @RequestMapping("/invokePersonJob")
    public ResponseEntity<String> handle() throws Exception {
        JobParameters jobParameters = new JobParametersBuilder()
                .addString("startTs", String.valueOf(System.currentTimeMillis())).toJobParameters();
        final JobExecution jobExecution = jobLauncher.run(importUserJob, jobParameters);
        final String status = (BatchStatus.FAILED.equals(jobExecution.getStatus()) ||
                BatchStatus.STOPPED.equals(jobExecution.getStatus())) ? "Batch executed with failures!" : "Batch executed successfully!";
        return new ResponseEntity<>(status, HttpStatus.OK);
    }
}
