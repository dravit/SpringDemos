# SpringDemos
SpringDemos Questions:

## What are features of Spring?

_**Lightweight:**_
Spring is lightweight when it comes to size and transparency. The basic version of spring framework is around 1MB. And the processing overhead is also very negligible.

_**Inversion of control (IOC):**_
Loose coupling is achieved in spring using the technique Inversion of Control. The objects give their dependencies instead of creating or looking for dependent objects.

_**Aspect oriented (AOP):**_
Spring supports Aspect oriented programming and enables cohesive development by separating application business logic from system services.

_**Container:**_
Spring contains and manages the life cycle and configuration of application objects.

_**MVC Framework:**_
Spring comes with MVC web application framework, built on core Spring functionality. This framework is highly configurable via strategy interfaces, and accommodates multiple view technologies like JSP, Velocity, Tiles, iText, and POI. But other frameworks can be easily used instead of Spring MVC Framework.

_**JDBC Exception Handling:**_
The JDBC abstraction layer of the Spring offers a meaningful exception hierarchy, which simplifies the error handling strategy. Integration with Hibernate, JDO, and iBATIS: Spring provides best Integration services with Hibernate, JDO and iBATIS.

_**Transaction Management:**_
Spring framework provides a generic abstraction layer for transaction management. This allowing the developer to add the pluggable transaction managers, and making it easy to demarcate transactions without dealing with low-level issues. Spring’s transaction support is not tied to J2EE environments and it can be also used in container less environments.

## Describe some of the standard Spring events?

Spring provides the following standard events:

_**ContextRefreshedEvent:**_ This event is published when the ApplicationContext is either initialized or refreshed. This can also be raised using the refresh() method on the ConfigurableApplicationContext interface.

_**ContextStartedEvent:**_ This event is published when the ApplicationContext is started using the start() method on the ConfigurableApplicationContext interface. the user can poll their database or they can re/start any stopped application after receiving this event.

_**ContextStoppedEvent:**_ This event is published when the ApplicationContext is stopped using the stop() method on the ConfigurableApplicationContext interface. the users can do required housekeep work after receiving this event.

_**ContextClosedEvent:**_ This event is published when the ApplicationContext is closed using the close() method on the ConfigurableApplicationContext interface. A closed context reaches its end of life; it cannot be refreshed or restarted.

_**RequestHandledEvent:**_ This is a web-specific event telling all beans that an HTTP request has been serviced.

## What bean scopes does Spring support? Explain them.
The Spring Framework supports following five scopes, three of which are available only if the users use a web-aware Application Context.

_**Singleton:**_ This scopes the bean definition to a single instance per Spring IoC container.

_**Prototype:**_ This scopes a single bean definition to have any number of object instances.

_**Request:**_ This scopes a bean definition to an HTTP request. Only valid in the context of a web-aware Spring ApplicationContext

_**Session:**_ This scopes a bean definition to an HTTP session. Only valid in the context of a web-aware Spring ApplicationContext.

_**Global-session:**_ This scopes a bean definition to a global HTTP session. Only valid in the context of a web-aware Spring ApplicationContext.

## Explain Bean lifecycle in Spring framework?
Following is sequence of a bean lifecycle in Spring:

_**Instantiate:**_ First the spring container finds the bean’s definition from the XML file and instantiates the bean.

_**Populate properties:**_ Using the dependency injection, spring populates all of the properties as specified in the bean definition.

_**Set Bean Name:**_ If the bean implements **BeanNameAware** interface, spring passes the bean’s id to **setBeanName()** method.

_**Set Bean factory:**_ If Bean implements **BeanFactoryAware** interface, spring passes the beanfactory to **setBeanFactory()** method.

_**Pre Initialization:**_ Also called post process of bean. If there are any bean **BeanPostProcessors** associated with the bean, Spring calls **postProcesserBeforeInitialization()** method.

_**Initialize beans:**_ If the bean implements IntializingBean,its **afterPropertySet()** method is called. If the bean has **init** method declaration, the specified initialization method is called.

_**Post Initialization:**_ – If there are any **BeanPostProcessors** associated with the bean, their **postProcessAfterInitialization()** methods will be called.

_**Ready to use:**_ Now the bean is ready to use by the application

_**Destroy:**_ If the bean implements DisposableBean , it will call the **destroy()** method
