package exercitiul4;
import java.util.Random;

public class Ex4 {
    public static void main(String[] args) {
        Random rand = new Random();
       int nr1 = rand.nextInt(29)+1;

        System.out.println(nr1);
       int nr2 = rand.nextInt(30);

        System.out.println(nr2);
        int rest;
        while (nr2 != 0 ){
            rest = nr1 % nr2;
            nr1= nr2;
            nr2 =rest;
        }
        System.out.println("Cel mai mare divizor comun este "+ nr1);
    }
}
