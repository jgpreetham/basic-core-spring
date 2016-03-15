package com.home.spring.test;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.MessageSource;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.home.spring.beans.Cat;
import com.home.spring.beans.Circle;
import com.home.spring.beans.Dog;

/**
 * Run individual test cases to understand better. You can comment non related bean definitions in spring.xml
 * Un-comment the bean definition related to the test case, test case name is mentioned on top of the bean definitions so check and uncomment
 * Make sure to uncomment all the bean definitions required for test case, so please search the spring.xml from top to bottom before running the test case     
 * @author preetham
 *
 */
public class TestSpringProject {
	private static AbstractApplicationContext context = null;
	private static boolean contextInitialized = false;

	/**
	 * This method runs first before any of the test cases in the class 
	 * @throws Exception
	 */
	@BeforeClass
	public static void setUp() throws Exception {
		System.out.println("Loading the spring.xml from test case");
		context = new ClassPathXmlApplicationContext("spring.xml");
		contextInitialized=true;
		context.registerShutdownHook();

	}

	/**
	 * This method runs before each test case
	 */
	@Before
	public void init()
	{
		if(!contextInitialized)
		{
			System.out.println("test case init method called to initialize the application context as the context is closed");
			context = new ClassPathXmlApplicationContext("spring.xml");
			contextInitialized=true;
		}
	}
	/**
	 * This method runs once all the test cases completes
	 * @throws Exception
	 */
	@AfterClass
	public static void tearDown() throws Exception {
		System.out.println("Closing the context...");
		context.close();
		contextInitialized=false;
	}

	/**
	 * This test cases tests the setter injection of properties name,age
	 */
	@Test
	public void testSetterInjection() {
		System.out.println("Test case testSetterInjection begins........ ");
		System.out.println("check name and age properties ");
		Dog dog = context.getBean("dog",Dog.class);
		assertEquals("Haiku",dog.getName());
		assertEquals(1,dog.getAge());
		System.out.println("Dog object is "+ dog);
		System.out.println("Test case testSetterInjection ends........ ");
	}
	
	/**
	 * This test cases tests the constructor injection of properties name,age
	 */
	@Test
	public void testConstructorInjection() {
		System.out.println("Test case testConstructorInjection begins........ ");
		System.out.println("check name and age properties ");
		Dog dog = (Dog)context.getBean("dogConstructor");
		assertEquals("Haiku",dog.getName());
		assertEquals(1,dog.getAge());
		System.out.println("Dog object is "+ dog);
		System.out.println("Test case testConstructorInjection ends........ ");
	}
	
	/**
	 * This test cases tests the object injection of instance variable sweetFood,spicyFood
	 */
	@Test
	public void testObjectInjection() {
		System.out.println("Test case testObjectInjection begins........ ");
		System.out.println("check spicy food and sweet food properties(both of the food objects are also intialized) ");
		Dog dog = context.getBean("injectFoodToDog",Dog.class);
		assertEquals("sweet",dog.getSweetFood().getTaste());
		assertEquals("spicy",dog.getSpicyFood().getTaste());
		assertEquals("GradeA",dog.getSweetFood().getQuality());
		assertEquals("GradeC",dog.getSpicyFood().getQuality());
		System.out.println("Dog object is "+ dog);
		System.out.println("Test case testObjectInjection ends........ ");
	}
	
	/**
	 *This test cases tests the object injection of instance variable sweetFood,spicyFood but using inner beans 
	 */
	@Test
	public void testInnerBeanObjectInjection() {
		System.out.println("Test case testInnerBeanObjectInjection begins........ ");
		System.out.println("check spicy food and sweet food properties(both of the food objects are also intialized) ");
		Dog dog = context.getBean("innerBean",Dog.class);
		assertEquals("InnerBean sweet",dog.getSweetFood().getTaste());
		assertEquals("InnerBean Spicy taste",dog.getSpicyFood().getTaste());
		assertEquals("InnerBean GradeA",dog.getSweetFood().getQuality());
		assertEquals("InnerBean GradeC",dog.getSpicyFood().getQuality());
		System.out.println("Dog object is "+ dog);
		System.out.println("Test case testInnerBeanObjectInjection ends........ ");
	}
	
	/**
	 * This test cases tests the collection of objects injection of instance variable List<Food> foods
	 */
	@Test
	public void testCollectionBeanObjectInjection() {
		System.out.println("Test case testCollectionBeanObjectInjection begins........ ");
		System.out.println("check foods property ");
		Dog dog = context.getBean("injectCollectionFoodsToDog",Dog.class);
		assertEquals(2, dog.getFoods().size());
		System.out.println("Dog object is "+ dog);
		System.out.println("Test case testCollectionBeanObjectInjection ends........ ");
	}
	
	/**
	 * This test cases tests the object injection of instance variable sweetFood,spicyFood but using autowireByName
	 * Since the beans in the spring.xml has name (spicyFood,sweetFood) same as the instance variable names, the properties are autowired by name
	 */
	@Test
	public void testautoWireByName() {
		System.out.println("Test case testautoWireByName begins........ ");
		System.out.println("check spicy food and sweet food properties(both of the food objects are also intialized) ");
		Dog dog = context.getBean("autoWireByNameBean",Dog.class);
		assertEquals("sweet",dog.getSweetFood().getTaste());
		assertEquals("spicy",dog.getSpicyFood().getTaste());
		assertEquals("GradeA",dog.getSweetFood().getQuality());
		assertEquals("GradeC",dog.getSpicyFood().getQuality());
		System.out.println("Dog object is "+ dog);
		System.out.println("Test case testautoWireByName ends........ ");
	}
	
	/**
	 * This test cases tests the object injection of instance variable owner but using autowire by type
	 * Since there is only one Person type bean in the spring.xml, and cat has Person type instance variable, that bean is injected(autowired) to cat 
	 */
	@Test
	public void testautoWireByType() {
		System.out.println("Test case testautoWireByType begins........ ");
		System.out.println("check owner property(person is initialized with name and person is autowired to cat) ");
		Cat cat = context.getBean("autoWireByTypeBean",Cat.class);
		assertEquals("Forest Gump", cat.getOwner().getName());
		System.out.println("Cat object is "+ cat);
		System.out.println("Test case testautoWireByType ends........ ");
	}
	
	/**
	 * This test cases tests the object injection of instance variable owner but using autowire by constructor. Bean is injected via constructor
	 * Since there is only one Person type bean in the spring.xml, and cat has Person type instance variable, that bean is injected(autowired) to cat 
	 */
	@Test
	public void testautoWireByConstructor() {
		System.out.println("Test case testautoWireByConstructor begins........ ");
		System.out.println("check owner property(person is initialized with name and person is autowired to cat) ");
		Cat cat = context.getBean("autoWireByConstructorBean",Cat.class);
		assertEquals("Forest Gump", cat.getOwner().getName());
		System.out.println("Cat object is "+ cat);
		System.out.println("Test case testautoWireByConstructor ends........ ");
	}
	
	/**
	 * This test cases tests singleton scope of bean.
	 *  
	 */
	@Test
	public void testSingleton() {
		System.out.println("Test case testSingleton begins........ ");
		System.out.println("check name property ");
		Dog dog = context.getBean("singletonDog",Dog.class);
		assertEquals("Haiku",dog.getName());
		dog.setName("Name updated");
		System.out.println("Dog object after 1st getBean and updated name "+ dog);
		dog = context.getBean("singletonDog",Dog.class);
		assertEquals("Name updated",dog.getName());
		System.out.println("Dog object after 2nd getBean "+ dog + " . There is only one instance of dog so it still has the updated name instead of intialized name after the 2nd getbean() call");
		System.out.println("Test case testSingleton ends........ ");
	}
	
	/**
	 * This test cases tests prototype scope of bean.
	 *  
	 */
	@Test
	public void testProtoType() {
		System.out.println("Test case testProtoType begins........ ");
		System.out.println("check name property ");
		Dog dog = context.getBean("protoTypeDog",Dog.class);
		assertEquals("Haiku",dog.getName());
		dog.setName("Name updated");
		System.out.println("Dog object after 1st getBean and updated name"+ dog);
		dog = context.getBean("protoTypeDog",Dog.class);
		assertEquals("Haiku",dog.getName());
		System.out.println("Dog object after 2nd getBean "+ dog + " . There is new instance of dog for each getbean() call, so it has initialized name instead of updated name");
		System.out.println("Test case testProtoType ends........ ");
	}
	
	
	/**
	 * This test case tests the bean definition inheritance
	 */
	@Test
	public void testBeanDefnitionInheritance() {
		System.out.println("Test case testbeanDefnitionInheritance begins........ ");
		System.out.println("check name,age,sweetFood,spicyFood properties. name,age,sweetFood properties are inherited from parentDog  ");
		Dog dog = context.getBean("inheritanceDog",Dog.class);
		assertEquals("Haiku",dog.getName());
		assertEquals("sweet",dog.getSweetFood().getTaste());
		assertEquals("spicy",dog.getSpicyFood().getTaste());
		assertEquals("GradeA",dog.getSweetFood().getQuality());
		assertEquals("GradeC",dog.getSpicyFood().getQuality());
		System.out.println("Inherited dog is "+ dog);
		System.out.println("Test case testbeanDefnitionInheritance ends........ ");
	}
	
	/**
	 * This test case tests the bean definition inheritance with list property
	 */
	@Test
	public void testBeanDefnitionInheritanceWithList() {
		System.out.println("Test case testBeanDefnitionInheritanceWithList begins........ ");
		System.out.println("check foods property. sweetFood in foods is added in parentDog, spicyFood in foods was added in inheritied defnition. The list is merged because merge=true in bean definition");
		Dog dog = context.getBean("inheritanceDogWithList",Dog.class);
		assertEquals(2,dog.getFoods().size());
		System.out.println("Inherited dog is "+ dog);
		System.out.println("Test case testBeanDefnitionInheritanceWithList ends........ ");
	}
	
	/**
	 * This method tests the bean initialization,destruction method flow. You have to check the console output to understand 
	 */
	@Test
	public void testBeanInitializationAndDestruction() {
		System.out.println("Test case testBeanInitializationAndDestruction begins........ ");
		System.out.println("Observe the cat initalization and destruction method flow");
		context.getBean("initDestroyCat",Cat.class);
		System.out.println("Closing the context in the test case testBeanInitializationAndDestruction");
		context.close();
		//context is closed, so make contextInitialized=false. Check in init() method which runs for each test case and initialize again else further test cases fails.
		contextInitialized=false;
		System.out.println("Test case testBeanInitializationAndDestruction ends........ ");
	}
	
	
	/**
	 * This method is to test the bean post processor. Bean post processor adds "Processed" string to the cat bean name
	 */
	@Test
	public void testBeanPostProcessor() {
		System.out.println("Test case testBeanPostProcessor begins........ ");
		System.out.println("Check the beanName property, bean post processor adds the string \"Processed\" to the bean name ");
		Cat cat = context.getBean("beanPostProcessorCat",Cat.class);
		assertEquals("beanPostProcessorCatProcessed", cat.getBeanName());
		System.out.println("Cat object is "+ cat);
		System.out.println("Test case testBeanPostProcessor ends........ ");
	}
	
	
	/**
	 * This method is to test the bean factory post processor. Bean factory writes a line to console so check the console output
	 */
	@Test
	public void testBeanFactoryPostProcessor() {
		System.out.println("Test case testBeanFactoryPostProcessor begins........ ");
		System.out.println("Check the console for the output of bean factory post processor when the spring context loads");
		System.out.println("Test case testBeanFactoryPostProcessor ends........ ");
	}
	
	/**
	 * This method is to test the out of the box spring bean factory post processor property place holder. 
	 * It replaces the values of place holders from the property file(propertyValues.properties)
	 */
	@Test
	public void testBeanFactoryPostProcessorPropertyPlaceHolder() {
		System.out.println("Test case testBeanFactoryPostProcessor begins........ ");
		System.out.println("Check the name and age of the dog which is read from the propertyValues.properites file");
		Dog dog = (Dog)context.getBean("propertyDog");
		assertEquals("Name from Property file", dog.getName());
		assertEquals(5, dog.getAge());
		System.out.println("Dog created is " + dog);
		System.out.println("Test case testBeanFactoryPostProcessor ends........ ");
	}
	
	
	/**
	 * This method tests the Autowire by Annotation
	 */
	@Test
	public void testAutowireByAnnotation() {
		System.out.println("Test case testAutowireByAnnotation begins........ ");
		System.out.println(" If bean id=circle is not present and only one Point bean definition is present in spring.xml, it will autowire byType. If multiple Point bean definitions are present and bean id= center is present then it is injected to center instance variable of circle(autowire byName)");
		Circle circle = (Circle)context.getBean("circle");
		assertEquals(0, circle.getCenter().getX());
		assertEquals(0, circle.getCenter().getY());
		System.out.println("Circle object is "+ circle);
		System.out.println("Test case testAutowireByAnnotation ends........ ");
	}

	/**
	 * This method tests the Autowire and qualifier by Annotation 
	 */
	@Test
	public void testAutowireByAnnotationWithQualifier() {
		System.out.println("Test case testAutowireByAnnotationWithQualifier begins........ ");
		System.out.println(" If bean id=circle is not present and only one Point bean definition is present in spring.xml, it will autowire byType. If multiple Point bean definitions are present and bean id= center is present then it is injected to center instance variable of circle(autowire byName)");
		Circle circle = (Circle)context.getBean("circle");
		assertEquals(1, circle.getTestQualifier().getX());
		assertEquals(-1, circle.getTestQualifier().getY());
		System.out.println("Circle object is "+ circle);
		System.out.println("Test case testAutowireByAnnotationWithQualifier ends........ ");
	}
	
	
	/**
	 * This method tests getting the text from the property file and getting default message
	 */
	@Test
	public void testGettingTextFromPropertyFile() {
		System.out.println("Test case testGettingTextFromPropertyFile begins........ ");
		String message = context.getMessage("messageKey", null, "Default Message", null);
		assertEquals("Message from the property file",message);
		assertEquals("Default message as there no key in the property",context.getMessage("NonExistingKey", null, "Default message as there no key in the property", null));
		System.out.println("Message is " + message);
		System.out.println("Test case testGettingTextFromPropertyFile ends........ ");
	}

	/**
	 * This method tests getting the dynamic text from the property file and replacing the dynamic values
	 */
	@Test
	public void testGettingVariableTextFromPropertyFileWithMessageSource() {
		System.out.println("Test case testGettingVariableTextFromPropertyFileWithMessageSource begins........ ");
		Circle circle = context.getBean("circle",Circle.class);
		MessageSource messageSource = circle.getMessageSource();
		String message = messageSource.getMessage("variableMessageKey",new Object[]{"value1", "value2"},"Default message", null);
		System.out.println("Message is " + message);
		assertEquals("Values received are value1 and value2",message);
		System.out.println("Test case testGettingVariableTextFromPropertyFileWithMessageSource ends........ ");
	}


	
}
