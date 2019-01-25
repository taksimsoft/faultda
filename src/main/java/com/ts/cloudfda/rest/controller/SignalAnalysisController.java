package com.ts.cloudfda.rest.controller;

import com.ts.cloudfda.config.MessageListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
public class SignalAnalysisController {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());


    @Autowired
    MessageListener     listener;


    @GetMapping("/listen")
    private void    startListeners() throws InterruptedException {
        LOGGER.info("LISTEN");
        listener.getLatch().await(10, TimeUnit.SECONDS);
        listener.getPartitionLatch().await(10, TimeUnit.SECONDS);
        listener.getFilterLatch().await(10, TimeUnit.SECONDS);
        listener.getGreetingLatch().await(10, TimeUnit.SECONDS);
    }


}
