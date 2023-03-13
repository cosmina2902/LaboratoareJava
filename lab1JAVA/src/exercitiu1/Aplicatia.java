package exercitiu1;

import java.util.Scanner;

public class Aplicatia {
    public static void main(String[] args) {
    Scanner dim = new Scanner(System.in);
    System.out.println("Introduceti lungimea: ");
    int lungime = dim.nextInt();
    System.out.println("Introduceti latimiea: ");
    int latime = dim.nextInt();
    int permitertu = 2*lungime + 2*latime;
    int aria = lungime*latime;
        System.out.println("Permetru calculat este "+permitertu+" iar aria este "+aria);


    }
}
