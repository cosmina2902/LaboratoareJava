package exemplul07;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("beans07.xml");
        Persoana p=(Angajat)context.getBean("angajat");
        System.out.print(p);
    }
}
