package org.UnitTest;
import org.UnitTest.HomeWork.Week4;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
//        System.out.println("Hello world!");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        Week4 week4 = context.getBean(Week4.class);

        week4.someMethod();

        context.close();
    }
}