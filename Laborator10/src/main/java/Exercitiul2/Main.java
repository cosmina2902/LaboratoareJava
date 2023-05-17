package Exercitiul2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context =new ClassPathXmlApplicationContext("beans15.xml");
        OperatiiBD operatiiBD =(OperatiiBD)context.getBean("operatiiJDBC");

        System.out.println("Adaugare");
//       System.out.println("- Adaugare in BD" );
//       operatiiBD.insert("AR25LLL", "AUDI","2013","neagra","112 000km");

        System.out.println("- Afisarea persoanelor din BD:" );
        List<Masini> masini = operatiiBD.getListaMasini();
        for (Masini mas : masini) {
            System.out.println(mas);
        }
        System.out.println();

        System.out.println("--Stergere--");
//        operatiiBD.delete("AR25LLL");
//        System.out.println("- Afisarea persoanelor din BD dupa stergere:" );
//        List<Masini> masini2 = operatiiBD.getListaMasini();
//        for (Masini mas : masini2) {
//            System.out.println(mas);
//        }
        System.out.println();

        System.out.println("--Cautarea unei masini--");
        System.out.println( operatiiBD.getMasini("GJELY32"));

        System.out.println("--Afisare Masini dupa marca");
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduceti marca cautata ");
       String marca = sc.next();
     // System.out.println(operatiiBD.getListaMasiniMarca(marca.toLowerCase(Locale.ROOT)));
        System.out.println(operatiiBD.getNRListaMasiniMarca(marca));
      System.out.println();

        System.out.println("--Masini care au sub 100000 km--");
        System.out.println(operatiiBD.getListaMasiniKm());

        System.out.println("--Masini care sunt mai noi de 5 ani");
        System.out.println(operatiiBD.getMasiniNoiDe5Ani());


    }

}
