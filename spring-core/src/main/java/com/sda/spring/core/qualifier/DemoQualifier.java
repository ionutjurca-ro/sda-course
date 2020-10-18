package com.sda.spring.core.qualifier;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DemoQualifier {
    public static void main(String[] args) {
        //need foo service
        ApplicationContext context = new AnnotationConfigApplicationContext(QualifierConfig.class);
        FooService fooService = context.getBean("fooService", FooService.class);
        //FooService fooService1 = (FooService) context.getBean("fooService");
        fooService.run();
    }
}
