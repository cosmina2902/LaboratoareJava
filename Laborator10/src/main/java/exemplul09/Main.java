package exemplul09;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String []args){
       // ApplicationContext context=new ClassPathXmlApplicationContext("beans09_01.xml");
        ApplicationContext context=new ClassPathXmlApplicationContext("beans09_2.xml");
        Dreptunghi d=(Dreptunghi)context.getBean("dreptunghi");
        d.aria();
    }
}
