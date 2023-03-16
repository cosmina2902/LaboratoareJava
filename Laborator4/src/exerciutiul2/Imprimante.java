package exerciutiul2;

public class Imprimante extends Echipamente{
    private  int ppm;
    private String  rezolutie;
    private int p_car;
    private  ModTiparire modTiparire;

    public Imprimante(String denumire, int nr_inv, double pret, String zona_mag, Stare stare, int ppm, String rezolutie, int p_car, ModTiparire modTiparire) {
        super(denumire, nr_inv, pret, zona_mag, stare);
        this.ppm = ppm;
        this.rezolutie = rezolutie;
        this.p_car = p_car;
        this.modTiparire = modTiparire;
    }

    public int getPpm() {
        return ppm;
    }

    public void setPpm(int ppm) {
        this.ppm = ppm;
    }

    public String getRezolutie() {
        return rezolutie;
    }

    public void setRezolutie(String rezolutie) {
        this.rezolutie = rezolutie;
    }

    public int getP_car() {
        return p_car;
    }

    public void setP_car(int p_car) {
        this.p_car = p_car;
    }

    public ModTiparire getModTiparire() {
        return modTiparire;
    }

    public void setModTiparire(ModTiparire modTiparire) {
        this.modTiparire = modTiparire;
    }

    @Override
    public String toString() {
        return super.toString()+
                "Imprimante{" +
                "ppm=" + ppm +
                ", rezolutie=" + rezolutie +
                ", p_car=" + p_car +
                ", modTiparire=" + modTiparire +
                '}';
    }
}
