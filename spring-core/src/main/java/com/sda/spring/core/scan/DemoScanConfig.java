package com.sda.spring.core.scan;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DemoScanConfig {
    public static void main(String[] args) {

        //create context
        ApplicationContext appContext = new AnnotationConfigApplicationContext(ScanConfig.class);

        //get bean / component
        MyComponent myComponentfromContext = appContext.getBean("myComponent", MyComponent.class);

        //use bean
        myComponentfromContext.complexOperation();
        myComponentfromContext.hello();
    }
}
