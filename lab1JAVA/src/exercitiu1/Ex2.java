package exercitiu1;

import java.io.*;
import java.util.*;

public class Ex2 {


    public static void main(String[] args) throws IOException {

        String nume_fis = "src/exercitiu1/in.txt";
        BufferedReader flux_in;
        flux_in = new BufferedReader(new InputStreamReader(new FileInputStream(nume_fis)));
        String new_fis = "src/exercitiu1/out.txt";
        BufferedWriter fin;
        fin = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new_fis)));
        int total = 0;
        int k;
        int media = 0;
        int min = 999;
        int max = 0;
        int i = 0;
        int contor = 0;
        while (flux_in.ready()) {
            String linie = flux_in.readLine();
            System.out.println(linie);
            k = Integer.parseInt(linie);
            contor++;
            total += k;
            media = total /contor ;
            if (k < min)
                min = k;
            if (k > max)
                max = k;
        }
        System.out.println("SUma este " + total);
        System.out.println("Media este " + media);
        System.out.println("Minimul este " + min);
        System.out.println("Max este " + max);
        //fin.write(total);
        fin.write(String.valueOf(total));
        fin.newLine();
        fin.write(String.valueOf(media));
        fin.newLine();
        fin.write(String.valueOf(min));
        fin.newLine();
        fin.write(String.valueOf(max));
        fin.flush();
        fin.close();
    }
}

