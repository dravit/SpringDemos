/**
 * Jul 16, 2015
 * Dravit
 */
package com.dravit.spring.tutorial7;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Dravit
 *
 */
public class DrawingApp {
	public static void main(String args[]) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		Triangle triangle = (Triangle)context.getBean("triangle7");
		triangle.draw();
	}

}
