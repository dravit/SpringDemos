package com.dravit.spring.tutorial9;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DrawingApp {
	public static void main(String[] args) {
		//ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		context.registerShutdownHook(); 	//Register a shutdown hook with the JVM runtime, closing this context on 
											//JVM shutdown unless it has already been closed at that time.
		Triangle triangle = (Triangle) context.getBean("triangle9");
		triangle.draw();
	}
}
