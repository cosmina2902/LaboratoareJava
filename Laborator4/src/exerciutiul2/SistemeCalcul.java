package exerciutiul2;

public class SistemeCalcul extends Echipamente{
    private String tip_mon;
    private double vit_proc;
    private String c_hdd;
    private SistemOperare sistemOperare;

    public SistemeCalcul(String denumire, int nr_inv, double pret, String zona_mag, Stare stare, String tip_mon, double vit_proc, String c_hdd, SistemOperare sistemOperare) {
        super(denumire, nr_inv, pret, zona_mag, stare);
        this.tip_mon = tip_mon;
        this.vit_proc = vit_proc;
        this.c_hdd = c_hdd;
        this.sistemOperare = sistemOperare;
    }

    public String getTip_mon() {
        return tip_mon;
    }

    public void setTip_mon(String tip_mon) {
        this.tip_mon = tip_mon;
    }

    public double getVit_proc() {
        return vit_proc;
    }

    public void setVit_proc(double vit_proc) {
        this.vit_proc = vit_proc;
    }

    public String getC_hdd() {
        return c_hdd;
    }

    public void setC_hdd(String c_hdd) {
        this.c_hdd = c_hdd;
    }

    public SistemOperare getSistemOperare() {
        return sistemOperare;
    }

    public void setSistemOperare(SistemOperare sistemOperare) {
        this.sistemOperare = sistemOperare;
    }

    @Override
    public String toString() {
        return super.toString()+
                 "SistemeCalcul{" +
                "tip_mon='" + tip_mon + '\'' +
                ", vit_proc=" + vit_proc +
                ", c_hdd='" + c_hdd + '\'' +
                ", sistemOperare=" + sistemOperare +
                '}';
    }
}
