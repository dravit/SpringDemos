package com.dravit.spring.tutorial9;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/*
 * Allows for custom modification of an application context's bean definitions, 
 * adapting the bean property values of the context's underlying bean factory. .
 */
public class MyBeanFactoryPP implements BeanFactoryPostProcessor {
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		// TODO Auto-generated method stub
		System.out.println("My Bean Factory Post Processer.");
	}

}
