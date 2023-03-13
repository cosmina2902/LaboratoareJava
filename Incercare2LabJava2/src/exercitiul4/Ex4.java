package exercitiul4;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Ex4 {
    public static class Persoana {
       private   String nume;
         private String cnp;
        private Integer varsta;

        public Persoana(String nume, String cnp) {
            this.nume = nume;
            this.cnp = cnp;

        }

        public String getNume() {
            return nume;
        }

        public void setNume(String nume) {
            this.nume = nume;
        }

        public String getCnp() {
            return cnp;
        }

        public void setCnp(String cnp) {
            this.cnp = cnp;
        }

        public Integer getVarsta() {
            return varsta;
        }

        public void setVarsta(Integer varsta) {
            this.varsta = varsta;
        }

        public int calculVarsta() {
            String date = "";
            switch ((cnp.charAt(0))) {
                case '1':
                    date += 19;
                    break;
                case '2':
                    date += 19;
                    break;
                case '5':
                    date += 20;
                    break;
                case '6':
                    date += 20;

            }
            date += cnp.substring(1, 3) + "-" + cnp.substring(3, 5) + "-" + cnp.substring(5, 7);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate localDate = LocalDate.now();
            LocalDate curent = LocalDate.parse(date, formatter);
            return Period.between(curent, localDate).getYears();
        }

        public String toString() {
            return nume + ", " + cnp + ", " + getVarsta() + " ani";
        }

    }

    public static void main(String[] args) {
        System.out.print("Introduceti n= ");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        //  Scanner scanner1 = new Scanner(System.in);
        ArrayList<Persoana> persoane = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            System.out.println("Introduceti numele si CNP-ul persoanei " + (i + 1));
            String nume = scanner.nextLine();
            String cnp = scanner.nextLine();


            while (!isValidCnp(cnp)) {
                System.out.println("CNP-ul introdus nu este valid. Va rugam sa reintroduceti CNP-ul:");
                cnp = scanner.nextLine();
            }
            Persoana persoana = new Persoana(nume, cnp);
            persoana.setVarsta(persoana.calculVarsta());
            persoane.add(persoana);
        }
        for (Persoana p : persoane) {
            System.out.println(p.toString());
        }
    }

    private static boolean isValidCnp(String cnp) {
        if (cnp.length() != 13) {
            return false;
        }
        int[] coef = {2, 7, 9, 1, 4, 6, 3, 5, 8, 2, 7, 9};
        int sum = 0;

        for (int i = 0; i < 12; i++) {
            sum += Integer.parseInt(cnp.substring(i, i + 1)) * coef[i];
        }

        int control = sum % 11;
        if (control == 10) {
            control = 1;
        }
        return (control == Integer.parseInt(cnp.substring(12)));
    }
}
