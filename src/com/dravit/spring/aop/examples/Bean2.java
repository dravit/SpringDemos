package com.dravit.spring.aop.examples;

import org.apache.log4j.Logger;

import java.text.MessageFormat;

public class Bean2 {
    Logger logger = Logger.getLogger(Bean2.class);

    public void importantMethod(){
        logger.info("Doing job for 3 seconds");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void doSomethingQuick(String param1) {
        logger.info(MessageFormat.format("doing something quick with param = {0}",param1));
    }
}