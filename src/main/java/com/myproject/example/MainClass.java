package com.myproject.example;

/**
 * Created by stpl on 18/12/18.
 */
public class MainClass {
    public static void main(String... arg) {
    }
}

//In spring autowiring, @Autowired annotation handles only wiring part. We still have to define the beans so the container is aware of them and can inject them for you.

//With @Component, @Repository, @Service and @Controller annotations in place and automatic component scanning enabled, Spring will automatically import the beans into the container and inject to dependencies. These annotations are called Stereotype annotations as well.

//The @Component annotation marks a java class as a bean so the component-scanning mechanism of spring can pick it up and pull it into the application context. To use this annotation, apply it over class as below:

//@Component used to auto-detect and auto-configure beans using classpath scanning. There’s an implicit one-to-one mapping between the annotated class and the bean (i.e. one bean per class).

//@Bean is used to explicitly declare a single bean, rather than letting Spring do it automatically for us.
