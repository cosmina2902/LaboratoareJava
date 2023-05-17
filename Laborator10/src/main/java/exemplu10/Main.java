package exemplu10;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("beans10.xml");
        Figura f=(Figura)context.getBean("cerc");
        //Figura f=(Figura)context.getBean("dreptunghi");
        f.aria();
    }
}
