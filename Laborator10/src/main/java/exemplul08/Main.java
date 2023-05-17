package exemplul08;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

            AbstractApplicationContext context=new ClassPathXmlApplicationContext("beans08.xml");
            Dreptunghi d=(Dreptunghi)context.getBean("dreptunghi");
            d.aria();
            context.registerShutdownHook();
            context.close();
        }
    }

