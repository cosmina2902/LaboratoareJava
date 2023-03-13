package exercitiul2;

import javax.management.StringValueExp;
import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class Ex2 {
    public static class Vers {
        String linie;

        public Vers(String linie) {
            this.linie = linie;
        }

        public int numarCuvinte() {
            return linie.split("\\s+").length;
        }


        public String afisareCuMasuraSiVocale() {
            int cuvinte = numarCuvinte();
            int vocale = nrVocale(linie);
            String afisare =linie;
            if (linie.endsWith("nd")) {
                afisare += " * ";
            }
            afisare +=  " (" + cuvinte + " cuvinte, " + vocale + " vocale)";
            Random random = new Random();
            double numar = random.nextDouble(1);
            if (numar < 0.1)
            {
                afisare = linie.toUpperCase()+" (" + cuvinte + " cuvinte, " + vocale + " vocale)" + numar;
            }
            else
                 afisare+= " " +numar;
            return afisare;


        }

        public static int nrVocale(String line) {
            int vocale = 0;
            for (int i = 0; i < line.length(); i++) {
                char c = Character.toLowerCase(line.charAt(i));
                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                    vocale++;
                }
            }
            return vocale;
        }

    }
    public static void main(String[] args) throws IOException {
        String cantec = "src/exercitiul2/cantec.txt";
        BufferedReader flux_in ;
        flux_in = new BufferedReader( new InputStreamReader(new FileInputStream(cantec)));
        String cantecOUT= "src/exercitiul2/cantecOUT.txt";
        BufferedWriter flux_out;
        flux_out = new BufferedWriter(new OutputStreamWriter( new FileOutputStream(cantecOUT)));
        String linie;
        ArrayList<Vers> versuri= new ArrayList<>();
        while ((linie=flux_in.readLine())!=null){
            Vers vers = new Vers(linie);
            versuri.add(vers);
        }
        for (Vers vers : versuri){
            String afisare = vers.afisareCuMasuraSiVocale();
            flux_out.write(afisare);
            flux_out.newLine();
        }
        flux_in.close();
        flux_out.close();
   }
}
