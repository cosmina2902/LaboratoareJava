package exempleCurs;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
       // ApplicationContext context=new ClassPathXmlApplicationContext("beans03_01.xml");
        //ApplicationContext context=new ClassPathXmlApplicationContext("beans03_02.xml");
        ApplicationContext context=new ClassPathXmlApplicationContext("beans03_03.xml");
        Persoana p=(Persoana)context.getBean("pers");
        System.out.print(p);
    }
}
