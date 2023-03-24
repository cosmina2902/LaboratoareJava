package exercitiul1;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import exmp1.Persoana;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main {
    static void scriere(List<PerecheNumere> lista) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            File file = new File("src/main/resources/perechiNumere.json");
            mapper.writeValue(file, lista);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<PerecheNumere> citire() {
        try {
            File file = new File("src/main/resources/perechiNumere.json");
            ObjectMapper mapper = new ObjectMapper();
            List<PerecheNumere> numere = mapper.readValue(file, new TypeReference<List<PerecheNumere>>() {
            });
            return numere;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        List<PerecheNumere> numeres = citire();
        System.out.println(numeres);
        numeres.add(new PerecheNumere(4, 12));
        scriere(numeres);

        for (PerecheNumere nr : numeres) {
            int nr1 = nr.getA();
            int nr2 = nr.getB();
            if (nr.Fibbonaci(nr1, nr2)) {
                System.out.println("nr " + nr1 + " si nr " + nr2 + " sunt perechi ale lui Fibbonaci");
            }

        }
        for (PerecheNumere per : numeres) {
            int nr1 = per.getA();
            int nr2 = per.getB();
            System.out.println("Cmmdc este " + per.Cmmdc(nr1, nr2));
        }
        for (PerecheNumere nr : numeres) {
            int nr1 = nr.getA();
            int nr2 = nr.getB();
            if (nr.Sumacif(nr1, nr2))
                System.out.println("Suma cifrelor dintre " + nr1 + " si " + nr2 + " este de egala");
        }
        for (PerecheNumere nr : numeres) {
            int nr1 = nr.getA();
            int nr2 = nr.getB();
            if (nr.CifPare(nr1, nr2))
                System.out.println("Nr " + nr1 + " si nr " + nr2 + " au acelasi numar de cifre pare");

        }
    }
}
