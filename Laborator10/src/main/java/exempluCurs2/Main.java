package exempluCurs2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
//        ApplicationContext context = new ClassPathXmlApplicationContext("beans04.xml");
//        Persoana p = (Persoana) context.getBean("pers");
//        System.out.println(p);
        ApplicationContext context=new ClassPathXmlApplicationContext("beans05.xml");
        Mesaj m1=(Mesaj)context.getBean("mesaj");
        System.out.println("Obiectul m1 dupa creare:"+m1);
        m1.setMesaj("Al doilea mesaj!");
        System.out.println("Obiectul m1 dupa setare:"+m1);
        Mesaj m2=(Mesaj)context.getBean("mesaj");
        System.out.println("Obiectul m2 dupa creare:"+m2);

    }
}
