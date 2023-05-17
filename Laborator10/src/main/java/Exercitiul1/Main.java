package Exercitiul1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("beans_lab1.xml");
        Vehicul vehicul=(Vehicul) context.getBean("autoturism");
        System.out.print(vehicul);
        System.out.println();
        Vehicul vehicul1=(Vehicul)context.getBean("autoturism2");
        System.out.println(vehicul1);
        System.out.println();

        AbstractApplicationContext context2=new ClassPathXmlApplicationContext("beans_lab1.xml");
        Vehicul mot = (Vehicul)context2.getBean("motocicleta");
        System.out.println(mot);
        context2.registerShutdownHook();
        context2.close();
        System.out.println();

        AbstractApplicationContext  context3=new ClassPathXmlApplicationContext("beans_lab2.xml");
        Vehicul v=(Vehicul)context3.getBean("tir");
        System.out.println(v);
        context3.registerShutdownHook();
        context3.close();


    }
}
