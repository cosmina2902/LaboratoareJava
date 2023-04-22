package Exercitiul2;

public class SetTobe extends InstrumentMuzical{
    private TipTobe tipTobe;
    private Integer nr_tobe;
    private Integer nr_cinele;

    public SetTobe() {

    }

    public SetTobe(String producator, Integer pret, TipTobe tipTobe, Integer nr_tobe, Integer nr_cinele) {
        super(producator, pret);
        this.tipTobe = tipTobe;
        this.nr_tobe = nr_tobe;
        this.nr_cinele = nr_cinele;
    }

    public TipTobe getTipTobe() {
        return tipTobe;
    }

    public void setTipTobe(TipTobe tipTobe) {
        this.tipTobe = tipTobe;
    }

    public Integer getNr_tobe() {
        return nr_tobe;
    }

    public void setNr_tobe(Integer nr_tobe) {
        this.nr_tobe = nr_tobe;
    }

    public Integer getNr_cinele() {
        return nr_cinele;
    }

    public void setNr_cinele(Integer nr_cinele) {
        this.nr_cinele = nr_cinele;
    }

    @Override
    public String toString() {
        return super.toString()+ "SetTobe{" +
                "tipTobe=" + tipTobe +
                ", nr_tobe=" + nr_tobe +
                ", nr_cinele=" + nr_cinele +
                '}';
    }
}
