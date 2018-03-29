**Spring is an open source framework that :**
- Addresses the complexity of enterprise application development
- Provides simplicity and loose coupling.
	
**Key feature stack :**
- Lightweight
- Dependency Injection
- Aspect Oriented
- Container
- Framework
	
**Spring is non-intrusive** : objects in a Spring-enabled application often have no dependencies on Spring-specific classes

#### Dependency Injection or Inversion Of Control(IOC)
- A mechanism to load pre-known object object dependencies before starting the application is known as dependency injection.
- Traditionally, each object is responsible for obtaining its own references to the objects it collaborates with (its dependencies).
This can lead to highly coupled and hard-to-test code.
- To apply DI objects can obtain their dependency at creation time by some external entity(DI container) that coordinates each object in the system.
- Spring promotes **loose coupling** through a technique known as **dependency injection (DI)**. 
- When DI is applied, objects are passively given their dependencies instead of creating or looking for dependent objects for themselves. 
- You can think of DI as JNDI in reverse—instead of an object looking up dependencies from a container, the container gives the dependencies to the object at instantiation without waiting to be asked.
- Spring framework comes up with a DI container which loads pre-known dependencies of an object at object creation. An object, for which dependency injection is required, is mapped with a bean in a Spring configuration file. All the dependencies are defined in the configuration file.
- To avail the benefits of Spring DI, a bean is created by the Spring container in place of creating the object with the new operator.
- The act of creating these associations between application objects is the essence of dependency injection (DI) and is commonly referred to as wiring of objects.

#### Spring Container
- The spring container is at the core of the Spring Framework.
- Spring’s container uses dependency injection (DI) to manage the components that make up an application. 
- This includes creating associations between collaborating components. As such, these objects are cleaner and easier to understand, support reuse, and are easy to unit-test
- Container comes with two main types of interfaces
	- org.springframework.beans.factory.BeanFactory
	- org.springframework.context. ApplicationContext

> **_Difference between BeanFactory and ApplicationContext:_**
	> - **BeanFactory** is responsible for the life cycle of bean, i.e creation and disposal of bean. Can be instantiated as 
	`BeanFactory factory = new XmlBeanFactory(resource);`
	> - **ApplicationContext** is the sub class of bean factory, it provides the additional functionality such as : 
		> - the ability to resolve textual messages from a properties file, including support for internationalization of those messages
		> - the ability to publish application events to beans that are registered as event listeners
		> - Provide generic way to load file resource, such as images
- Because of additional functionality, ApplicationContext is preferred over BeanFactory in most of the application.
- BeanFactory are used in circumstance where resources are scare, like mobile devices.
- Bean Factory is the  implementation of the factory design pattern.
- It is a heavy weight object, which  is responsible for creating and disposable of beans.
- When we create an instance of bean factory, Spring container is loaded to serve its facilities.
- Bean factory also takes part in the life cycle of a bean, making calls to custom initialization and destruction methods, if those methods are defined.

- **Beans are “lazily” loaded into bean factories**, meaning that while the bean factory will immediately load the bean definitions, the beans themselves will not be instantiated until they are needed.
- When getBean() is called on the bean factory, the factory instantiates the bean and set the bean’s properties using DI.

#### Resource
- Resource is only an interface. It's implementations are ClassPathResource, FileSystemResource, InputStreamResource and UrlResource.
- These are used to load a resource from a locations.
- ClassPathResource is one of its implementations for loading a resource from the class path. 

#### ApplicationContext - 3 that are commonly used:
- **ClassPathXmlApplicationContext** — Loads a context definition from an XML file located in the class path, treating context definition files as class path resources. 
`ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");`
- **FileSystemXmlApplicationContext** — Loads a context definition from an XML file in the file system.
- **XmlWebApplicationContext** — Loads context definitions from an XML file contained within a web application.
- **Multiple configuration** files can be added either by importing them in one configuration file or by using an overloaded constructor of ClassPathXmlApplicationContext.
    `ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"bean1.xml", "bean2.xml"});`

#### Bean LifeCycle:
- Instantiate {Bean Instance creation}
- Populate Properties {Fill Dependencies}
- BeanNameAware's setBeanName() {If bean implements BeanNameAware, Spring passes the bean name to setBeanName()}
- BeanFactoryAware's setBeanFactory() {If bean implemments BeanFactoryAware, Spring passes the bean factory to setBeanFactory()}
- ApplicationContextAware's   setApplicationContext() {If bean implements ApplicationContextAware, Spring passes the application context to setApplicationContext()}
- Pre-initialization BeanPostProcessors
- Initializing Bean's afterPropertiesSet() {If bean implements InitializingBean, its afterPropertiesSet() methid is called}
- Call custom init-method {If custom init method is defined in the configuration file init-method is called}
- Post-initialization BeanPostProcessors

						Bean is ready to use now
					---------------------------------------
						After use and Container Shutdown

- Disposable Bean's destroy() {If bean implements DisposableBean it's destroy() method is called}     >
- Call custom destroy method {If a custom destroy method is defined in configuration file, destroy-method is called}.

#### Spring Injections : 
- **Setter based injection** : realized by calling setters on your beans. Provide setter methods for each property. Use <property> tag in xml to configure value.
- **Constructor based injection** : realized by invoking a constructor with a number of arguments. Write constructor with the properties as arguments. Use <constructor-arg> tag in xml to configure value.
- **Factory method** : Objects are injected from the factory method.

#### Annotations : 
- **Auto wiring by annotation** : you need to add a bean post processor {AutoWiredAnnotationBeanPostProcessor} in configuration file.
    `<bean class="org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor" />`
- Alternatively, you can simply include the ** `<context:annotation-config>` ** element in your bean configuration file, and an AutowiredAnnotationBeanPostProcessor instance will automatically get registered.

#### @Autowired annotation : 
- By default, all the properties with @Autowired are required. 
- If a dependency is not found, an exception{org.springframework.beans.factory.UnsatisfiedDependencyException} is thrown. This is good in some circumstance when you want to ensure that all dependent objects have provided their dependencies.
- Making autowiring error safe using required=false
- If you want a certain property to be optional, you will have to set the required attribute of `@Autowired(required=false)` annotation to false.
- If you want to apply optional autowiring at global level i.e. for all properties in all beans; use below configuration setting : 
`<bean class="org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor">
    <property name="requiredParameterValue" value="false" />
</bean>`
- Excluding a bean from being available for autowiring :
> - By default, autowiring scan and matches all bean definitions in scope.
> - If you want to exclude some bean definitions so that they can not be injected through autowiring mode, you can do this using 'autowire-candidate' set to false.
> - Using 'autowire-candidate' as false totally exclude a bean from being an autowire candidate.
```
<bean id="finance" class="DepartmentBean" autowire-candidate="false">
	<property name="name" value="Finance" />
</bean>
```
> - Another option is to limit autowire candidates based on pattern-matching against bean names.
> - The top-level element accepts one or more patterns within its 'default-autowire-candidates' attribute.
> - For example, to limit autowire candidate status to any bean whose name ends with 'Impl', provide a value of `*Impl`.
> - To provide multiple patterns, define them in a comma-separated list.
        `<beans default-autowire-candidates="*Impl,*Dao">`
> - Note that an explicit value of 'true' or 'false' for a bean definition's 'autowire-candidate' attribute always takes
    precedence, and for such beans, the pattern matching rules will not apply.
- **@Autowired** annotation can also be applied to a constructor. Then Spring will attempt to find a bean with the compatible type for each of the constructor arguments.
- **@Autowired** annotation can also be applied to a **field**, even if it is not declared as public. In this way, you can omit the need of declaring a setter method or a constructor for this field.

#### @Resource : 
- If you want to auto-wire bean properties by name, you can annotate a setter method, a constructor, or a field with the JSR-250 @Resource annotation. 
- By default, Spring will attempt to find a bean with the same name as this property and if you want to change name by which it will find you can specify by :
```
	@javax.annotation.Resource	==>> This one is default
	@javax.annotation.Resource(name="some bean name here")	==>> This one will map with the mentioned bean name.
```

#### @Value : 
- Wiring hardcoded values using @Value
```
    @Value("India")
    private String country;
```

#### <context:component-scan> or Automatic Discovering Beans : 
- The **<context:component-scan>** element does everything that <context:annotation-config> does, plus it configures Spring to automatically discover beans and declare them for you.
- The <context:component-scan> element works by scanning a package and all of its sub-packages, looking for classes that could be automatically registered as beans in the Spring container.
- The base-package attribute tells <context:component-scan> the package to start its scan from.
```
<context:component-scan base-package="name of base package" />
```
- By default, <context:component-scan> looks for classes that are annotated with one of a handful of special stereotype annotations: 
	> - **@Component :** A general-purpose stereotype annotation indicating that the class is a Spring component
	> - **@Controller :** Indicates that the class defines a Spring MVC controller
	> - **@Repository :** Indicates that the class defines a data repository
	> - **@Service :** Indicates that the class defines a service
	> - Any **custom annotation** that is itself annotated with @Component  
- By default, the bean’s ID will be generated by camel-casing the class name. A bean with name mySQLDB is generated for the MySQLDB class.
- If you want to change the name of the bean, you can annotate your bean class as follows: 
```
@Component(name="new bean name")
public class MySQL {...}
```
		
#### Bean scoping :
- By default, all Spring beans are singletons. That means it will always hand out the exact same instance of the bean when asked for.
- We can change the scope of the bean among below given scope:
	> - **Singleton :** Creates a single bean instance per single IOC container
	> - **prototype :** creates a new bean instance each time when requested
	> - **request :** creates a single bean instance per http request; only valid in context of web application
	> - **session :** creates a single bean instance per http session; only valid in context of web application
	> - **globalSession :** creates a single bean instance per global http session; only valid in context of portal application.
- If a parent bean is singleton and child bean is prototype and two different calls are made for parent bean than only one instance of parent bean is created and one instance of child bean is created and again that same instance will be returned even in case of different child object.
- Scope can be defined using annotations
`@Scope(BeanDefinition.SCOPE_PROTOTYPE)`	

#### Lazy Initialization :
- By default, Spring create all the singleton scoped beans on startup in case of Application Context. This behavior can be changed to lazy initialization – load the on demand.
`lazy-init="true"`
- **@Lazy Annotation** : If present and set to true, the @Bean or @Component will not be initialized until referenced by another bean or explicitly retrieved from the enclosing BeanFactory.
- If Lazy is present on a @Configuration class, this indicates that all @Bean methods within that @Configuration should be lazily initialized
	
**How to resolve circular dependency between beans in Spring IoC?**
> This is from Spring Reference : 
> "You can generally trust Spring to do the right thing. It detects configuration problems, such as references to
> non-existent beans and circular dependencies, at container load-time.
> Spring sets properties and resolves dependencies as late as possible, when the bean is actually created.
> So it instantiates both beans and injects them onto each other."
- **BeanCurrentlyInCreationException** mostly arose due to constructor injection. If that is the case, mostly using setter injection instead of constructor injection will solve the issue. Constructor injection typically gives rise to the chicken-egg problem!

**Can we create a Spring bean even if the constructor is private?**
> Yes, spring can create bean even if constructor is private. It can call that constructor using Reflection.

**What will happen if we have duplicate bean Id's in same spring context? Will Spring throw an Error or Exception?**
> No, Spring will not throw any exception in this case. It will override the previous one with new one.
	
	
	 
	 
	



 
	
