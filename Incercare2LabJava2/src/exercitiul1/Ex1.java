package exercitiul1;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Ex1 {
    public static void afis(String []v) {
        for(int i=0;i<v.length && v[i]!= null;i++)
            System.out.print(v[i]+" ");
        System.out.println();
    }
    public static void main(String[] args) throws IOException {
        String nume_fix = "src/exercitiul1/judete.txt";
        BufferedReader cit;
        cit = new BufferedReader(new InputStreamReader(new FileInputStream(nume_fix)));


        int index = 0;
        String[] judete = new String[100];
        Arrays.fill(judete,null);
        String line;
        while ((line = cit.readLine()) != null) {
            if (!line.trim().isEmpty()) {

                judete[index] = line;
                index++;
            }
        }
        judete = Arrays.copyOf(judete, index);
        Arrays.sort(judete);
        afis(judete);
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduceti un judet de la tastatura ");
        String judet = scanner.nextLine();
        int poz = Arrays.binarySearch(judete, judet);
        System.out.println(poz>=0?"Judetul "+judet+" este gasit pe pozitia "+poz:"Nu se gaseste!");


    }
}
