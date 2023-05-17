package exemplu10;

public interface Figura {
    public void aria();
}
class Dreptunghi implements Figura{
    private int lungime;
    private int latime;
    public Dreptunghi(int lungime, int latime) {
        this.lungime = lungime;
        this.latime = latime;
    }
    public void aria() {
        System.out.println("Aria dreptunghiului: "+(lungime*latime));
    }
}
class Cerc implements Figura{
    private double raza;
    public void aria() {
        System.out.println("Aria cercului: "+Math.PI*raza*raza);
    }
    public double getRaza() {
        return raza;
    }
    public void setRaza(double raza) {
        this.raza = raza;
    }
 }