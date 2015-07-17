/**
 * Jul 13, 2015
 * Dravit Gupta
 */
package com.dravit.spring.tutorial1to6;

//import org.springframework.beans.factory.BeanFactory;
//import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
//import org.springframework.core.io.FileSystemResource;

public class DrawaingApp {
	public static void main(String args[]) {
		/**
		 * BeanFactory and ApplicationContext both are interfaces.
		 * BeanFactory only provides functionality of Bean instantiation/wiring
		 * ApplicationContext provide:
		 * <i>1.</i> Bean instantiation/wiring
		 * <i>2.</i> Automatic BeanPostProcessor registration
		 * <i>3.</i> Automatic BeanFactoryPostProcessor registration
		 * <i>4.</i> Convenient MessageSource access (for i18n)
		 * <i>5.</i> ApplicationEvent publication
		 * 
		 * ApplicationContext: It loads spring beans configured in spring configuration file,and manages 
		 * the life cycle of the spring bean as and WHEN CONTAINER STARTS.It won't wait until getBean("springbeanref") is called.
		 * 
		 * BeanFactory It loads spring beans configured in spring configuration file,manages the life cycle of the spring bean 
		 * when we call the getBean("springbeanref").So when we call the getBean("springbeanref") at the time of spring bean life cycle starts.
		 */
		//BeanFactory beanFactory = new XmlBeanFactory(new FileSystemResource("spring.xml"));
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		Triangle triangle = (Triangle) context.getBean("triangle");
		triangle.draw();
	}
}
