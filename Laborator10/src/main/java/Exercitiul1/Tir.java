package Exercitiul1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Tir extends Vehicul{
    private int incarcaturaMax;

    public Tir(String marca, int pret, int incarcaturaMax) {
        super(marca, pret);
        this.incarcaturaMax = incarcaturaMax;
    }

    public Tir() {
    }

    public int getIncarcaturaMax() {
        return incarcaturaMax;
    }

    @Value("200")
    public void setIncarcaturaMax(int incarcaturaMax) {
        this.incarcaturaMax = incarcaturaMax;
    }
    @PostConstruct
    public void init(){
        System.out.println("init()");
    }
    @PreDestroy
    public void destroy(){
        System.out.println("destroy()");
    }

    @Override
    public String toString() {
        return super.toString()+"Tir{" +
                "incarcaturaMax=" + incarcaturaMax +
                '}';
    }
}
