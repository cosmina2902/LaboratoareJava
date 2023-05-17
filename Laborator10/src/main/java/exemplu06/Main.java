package exemplu06;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main
{
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("beans06.xml");
        DouaMesaje m1=(DouaMesaje)context.getBean("mes1");
        System.out.println(m1);
        TreiMesaje m2=(TreiMesaje)context.getBean("mes2");
        System.out.println(m2);
    }
}
