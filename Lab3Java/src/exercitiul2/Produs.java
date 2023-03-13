package exercitiul2;

import java.io.*;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

import static java.time.LocalDate.*;

public class Produs {
    private String nume;
    private double pret;
    private int cantitate;
    private LocalDate date;
    static double incasari;

    public Produs(String nume, double pret, int cantitate, LocalDate date) {
        this.nume=nume;
        this.pret=pret;
        this.cantitate=cantitate;
        this.date=date;
    }


    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public double getPret() {
        return pret;
    }

    public void setPret(double pret) {
        this.pret = pret;
    }

    public int getCantitate() {
        return cantitate;
    }
    public void setCantitate(int cantitate) {
        this.cantitate = cantitate;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
    public static List<Produs> Expirate(List<Produs> produsList)
    {
        List<Produs>expirate = new ArrayList<Produs>();
        for(Produs p : produsList)
        {
            if(!Period.between(p.date,LocalDate.now()).isNegative())
            {
                expirate.add(p);
            }
        }
        return expirate;
    }
    public boolean Vinde(List<Produs> prod,int cant)
    {
        if(this.cantitate>cant)
        {
            this.cantitate-=cant;
            this.incasari+=this.pret*cant;
            if(cantitate==0)
            {
                prod.remove(this);
                return  true;
            }
        }
        return false;
    }
    public static double Minim(List<Produs> prod)
    {
        double minim = 9999.0;
        for(Produs p : prod)
        {
            if(p.pret<minim)
                minim=p.pret;
        }
        return minim;
    }
//    public static void Salvare(List<Produs> prod, int cantitate) throws IOException {
//
//
//
//
//    }
    @Override
    public String toString()
    {
        return "Nume "+this.nume +"\npret: "+this.pret+"\ncantitate: "+this.cantitate+"\ndata expirarii "+this.date+"\n************************************\n";
    }
}
