package com.dravit.spring.tutorial9;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * BeanPostProcesser are the classes that tells springs that some processes needs to be done after initializing the bean</br>
 * This is something that you can use in order to extend the functionality of spring.</br>
 * The single method runs for every initialization of every bean in spring.xml</br>
 * BeanPostProcesser is a separate class as we need to execute a method that will </br>
 * run with every initialization of bean, so that code can be at a common place. </br>
 * Difference between the init-method and Postprocess method is that you need to have </br>
 * init-method in that class only but in case of Post Process it is single class for all beans.
 */
public class DisplayNameBeanPostProcessor implements BeanPostProcessor{

	@Override
	public Object postProcessAfterInitialization(Object beanObject, String beanName) throws BeansException {
		// TODO Auto-generated method stub
		System.out.println("Post Process After Initialization of bean "+ beanName);
		return beanObject;
	}

	@Override
	public Object postProcessBeforeInitialization(Object beanObject, String beanName) throws BeansException {
		// TODO Auto-generated method stub
		System.out.println("Post Process Before Initialization of bean "+ beanName);
		return beanObject;
	}

}
