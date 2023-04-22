package Exercitiul2;

import java.util.Objects;

public class Chitara extends InstrumentMuzical{
    private TipChitara tipChitara;
    private int nrCorzi;

    public Chitara() {
    }



    public Chitara(String producator, Integer pret, TipChitara tipChitara, int nrCorzi) {
        super(producator, pret);
        this.tipChitara = tipChitara;
        this.nrCorzi = nrCorzi;
    }

    public int getNrCorzi() {
        return nrCorzi;
    }

    public void setNrCorzi(int nrCorzi) {
        this.nrCorzi = nrCorzi;
    }

    public TipChitara getTipChitara() {
        return tipChitara;
    }

    public void setTipChitara(TipChitara tipChitara) {
        this.tipChitara = tipChitara;
    }
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof Chitara)) {
            return false;
        }

        Chitara other = (Chitara) obj;

        return Objects.equals(this.getProducator(), other.getProducator())
                && this.getPret() == other.getPret()
                && Objects.equals(this.tipChitara, other.tipChitara)
                && this.nrCorzi == other.nrCorzi;
    }

    @Override
    public int hashCode() {
        return System.identityHashCode(this);
    }

    @Override
    public String toString() {
        return super.toString()+"Chitara{" +
                "tipChitara=" + tipChitara +
                ", nrCorzi=" + nrCorzi +
                '}';
    }
}
