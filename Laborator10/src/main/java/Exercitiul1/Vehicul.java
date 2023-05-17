package Exercitiul1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Vehicul {
    private String marca;

    private int pret;

    public Vehicul() {
    }

    public Vehicul(String marca, int pret) {
        this.marca = marca;
        this.pret = pret;
    }

    public String getMarca() {
        return marca;
    }
    @Value("Volvo")
    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getPret() {
        return pret;
    }
    @Value("15000")
    public void setPret(int pret) {
        this.pret = pret;
    }

    @Override
    public String toString() {
        return "Vehicul{" +
                "marca='" + marca + '\'' +
                ", pret=" + pret +
                '}';
    }
}
