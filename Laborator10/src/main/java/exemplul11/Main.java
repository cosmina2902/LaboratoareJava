package exemplul11;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("beans11.xml");
        Persoana p=(Persoana)context.getBean("pers");
        System.out.println(p);
    }
}
