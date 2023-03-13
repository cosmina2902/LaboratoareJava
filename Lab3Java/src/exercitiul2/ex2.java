package exercitiul2;

import javax.imageio.plugins.tiff.ExifGPSTagSet;
import javax.imageio.plugins.tiff.ExifTIFFTagSet;
import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ex2 {
    public static void main(String[] args) throws IOException {
        List<Produs> prod = new ArrayList<Produs>();
        String fisier = "src/exercitiul2/produse.csv";
        BufferedReader cit;
        String path="src/exercitiul2/iesire.txt";
        BufferedWriter scriere= new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path)));
        cit = new BufferedReader(new InputStreamReader(new FileInputStream(fisier)));
        String [] producs = new String[4];
       for( Produs p : prod)
           System.out.println(p);
       boolean ok = true;
       String linie;
        while(cit.ready())
        {
            linie=cit.readLine();
            producs=linie.split(",");
            prod.add(new Produs(producs[0],Double.parseDouble(producs[1].trim()),Integer.parseInt(producs[2].trim()),LocalDate.parse(producs[3].trim())));
        }
       do {
           System.out.println("1.Afisarea tuturor prod din colectia list");
           System.out.println("2.Afișarea produselor expirate");
           System.out.println("3.Vânzarea unui produs, care se poate realiza doar dacă există suficientă cantitate pe stoc.");
           System.out.println("4.Afișarea produselor cu prețul minim (pot fi mai multe cu același preț) .");
           System.out.println("5.Salvarea produselor care au o cantitate mai mică decât o valoare citită de la tastatură într-un fișier de ieșire. ");
           System.out.println("0.Exit");
           System.out.println("Introd opt: ");
           Scanner sc = new Scanner(System.in);
           int opt = sc.nextInt();
           switch (opt)
           {
               case 0:
                   System.exit(1);
                   break;
               case 1:

                   for(Produs p : prod)
                       System.out.println(p);
                   break;
               case 2:

                   System.out.println(Produs.Expirate(prod));
                   break;
               case 3:
                   System.out.println("Introduceti numele produsului:");
                   String nume = sc.next();
                   sc.nextLine();
                   System.out.println("Introduceti cantitatea dorita:");
                   int cantitate = sc.nextInt();
                   boolean produsGasit = false;
                   for(Produs p : prod) {
                       if(p.getNume().equals(nume)) {
                           produsGasit = true;
                           if(p.Vinde(prod, cantitate)) {
                               System.out.println("Produs vandut cu succes!");
                           } else {
                               System.out.println("Nu exista suficienta cantitate pe stoc!");
                           }
                           break;
                       }
                   }
                   if(!produsGasit) {
                       System.out.println("Produsul nu a fost gasit in lista!");
                   }
                   break;
               case 4:
                   System.out.println("Cel mai mic pret al produselor noastre este: "+Produs.Minim(prod));
                   break;
               case 5:

                   System.out.print("Introduceti cantitatea: ");
                   int cantit= sc.nextInt();
                   for(Produs p : prod)
                   {
                       if(p.getCantitate()<cantit)
                       {
                           scriere.write(String.valueOf(p));
                           System.out.println("S-a scris in fiser cu succes");
                       }
                   }

                   cit.close();
                   scriere.close();
                   break;
               default:
                   System.out.println("OPtiune invalida!");

           }

       }while (ok == true);
    }
}
