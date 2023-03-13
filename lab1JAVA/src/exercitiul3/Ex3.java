package exercitiul3;

import java.util.Scanner;

public class Ex3 {
    public static void main(String[] args) {
        Scanner new_nr = new Scanner(System.in);
        System.out.println("Introduceti nr: ");
        int nr = new_nr.nextInt();
        int divizori=0;
        for (int i = 2 ; i <= (nr/2); i++)
        {
            if(nr % i == 0)
            {
                divizori++;
                System.out.println(i);
            }
        }

        if(divizori == 0)
            System.out.println("Nr este prim");


    }

}
