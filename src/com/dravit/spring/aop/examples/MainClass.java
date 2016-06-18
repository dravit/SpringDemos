package com.dravit.spring.aop.examples;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by dgup27 on 4/27/2016.
 */
public class MainClass {
    public static void main(String[] args) {
        //ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("aop-spring.xml");
        context.registerShutdownHook(); 	//Register a shutdown hook with the JVM runtime, closing this context on
        //JVM shutdown unless it has already been closed at that time.
        Bean1 bean1 = (Bean1) context.getBean("bean1");
        bean1.entryPoint();
    }
}
