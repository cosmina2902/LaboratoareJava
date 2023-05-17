package Exercitiul1;

public class Autoturism extends Vehicul{
    private double VolumulPortbagajului;

    public Autoturism(String marca, int pret, double volumulPortbagajului) {
        super(marca, pret);
        VolumulPortbagajului = volumulPortbagajului;
    }

    public Autoturism() {
    }

    public double getVolumulPortbagajului() {
        return VolumulPortbagajului;
    }

    public void setVolumulPortbagajului(double volumulPortbagajului) {
        VolumulPortbagajului = volumulPortbagajului;
    }

    @Override
    public String toString() {
        return super.toString()+"Autoturism{" +
                "VolumulPortbagajului=" + VolumulPortbagajului +
                '}';
    }
}
