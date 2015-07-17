package com.dravit.spring.tutorial9;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.dravit.spring.tutorial7.Point;
/**
 * ApplicationContextAware is used to get the application context object.
 * A case when we need to use ApplicationContextAware is:
 * Suppose our main bean(Triangle) is singleton and we want our reference beans(Point beans) to be Prototype
 * i.e we want to set different point object on each call of singleton bean which is not possible from 
 * spring.xml
 * For this purpose we need ApplicationContext here so that we can set new Point objects every time.
 * 
 * BeanNameAware is only is used to get the name of the bean defined in xml.
 * 
 * There are two ways by which we can do some initialization task:
 * 1. By implementing InitializingBean interface and implementing its method afterPropertiesSet() , this will be automatically called by spring
 * 	  container.
 * 2. By defining our own init method and telling container in spring.xml that this is our init-method that needs to be run.
 * We can use both of initialization methods or only one of them what ever we want. If we are using both than the sequence will be first
 * interface method will get called than our method will get called. Same will work for destroy
 */
public class Triangle implements ApplicationContextAware, BeanNameAware, InitializingBean, DisposableBean{
	private List<Point> pointList;
	private Map<String, Point> pointMap;
	private Set<Point> pointSet;
	ApplicationContext context;

	/**
	 * @return the pointList
	 */
	public List<Point> getPointList() {
		return pointList;
	}

	/**
	 * @param pointList the pointList to set
	 */
	public void setPointList(List<Point> pointList) {
		this.pointList = pointList;
	}
	
	/**
	 * @return the pointMap
	 */
	public Map<String, Point> getPointMap() {
		return pointMap;
	}

	/**
	 * @param pointMap the pointMap to set
	 */
	public void setPointMap(Map<String, Point> pointMap) {
		this.pointMap = pointMap;
	}

	/**
	 * @return the pointSet
	 */
	public Set<Point> getPointSet() {
		return pointSet;
	}

	/**
	 * @param pointSet the pointSet to set
	 */
	public void setPointSet(Set<Point> pointSet) {
		this.pointSet = pointSet;
	}

	public void draw() {
		System.out.println("Drawing by List");
		for(Point point : getPointList()) {
			System.out.println("Point ("+point.getX() + "," + point.getY() + ")");
		}
		System.out.println("Drawing by Map");
		for(Map.Entry<String, Point> entry : getPointMap().entrySet()) {
			System.out.println("Point "+entry.getKey()+"("+entry.getValue().getX()+","+entry.getValue().getY()+")");
		}
		System.out.println("Drawing by Set");
		for(Point point : pointSet) {
			System.out.println("Point ("+point.getX() + "," + point.getY() + ")");
		}
	}

	@Override
	public void setBeanName(String name) {
		// TODO Auto-generated method stub
		System.out.println("Bean Name:"+name);
	}

	@Override
	public void setApplicationContext(ApplicationContext context) throws BeansException {
		// TODO Auto-generated method stub
		this.context = context;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("InitializingBean init method after properties like pointList etc. are set");
	}

	public void myInit() {
		System.out.println("This is my init method");
	}
	
	public void globalInit() {
		System.out.println("This is global init");
	}
	@Override
	public void destroy() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("DisposableBean destroy method before distruction");
	}
	
	public void myDestroy() {
		System.out.println("This is my destroy method.");
	}
	public void cleanUp() {
		System.out.println("This is my cleanUp");
	}
}
