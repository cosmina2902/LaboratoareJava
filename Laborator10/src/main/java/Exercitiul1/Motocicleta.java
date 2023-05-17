package Exercitiul1;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Motocicleta extends Vehicul implements InitializingBean, DisposableBean {
    private int VitezaMax;

    public Motocicleta(String marca, int pret, int vitezaMax) {
        super(marca, pret);
        VitezaMax = vitezaMax;
    }

    public Motocicleta() {
    }

    public int getVitezaMax() {
        return VitezaMax;
    }

    public void setVitezaMax(int vitezaMax) {
        VitezaMax = vitezaMax;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InitializingBean Motocicleta - afterPropertiesSet()");
    }
    @Override
    public void destroy() throws Exception {
        System.out.println("DisposableBean Motocicleta - destroy()");
    }
    @Override
    public String toString() {
        return super.toString()+"Motocicleta{" +
                "VitezaMax=" + VitezaMax +
                '}';
    }
}
