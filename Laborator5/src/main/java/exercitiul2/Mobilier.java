package exercitiul2;

import java.util.List;

public class Mobilier {
    static String nume;
    static List<Placa> placi;

    public Mobilier(String nume, List<Placa> placi) {
        this.nume = nume;
        this.placi = placi;
    }
    public Mobilier(){
        System.out.println("Constructor implicit");
    }

    public static String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public static List<Placa> getPlaci() {
        return placi;
    }

    public void setPlaci(List<Placa> placi) {
        this.placi = placi;
    }

    @Override
    public String toString() {
        return "Mobilier{" +
                "nume='" + nume + '\'' +
                ", placi=" + placi +
                '}';
    }
}
