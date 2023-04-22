package Exercitiul2;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.Objects;

@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS)
public abstract class InstrumentMuzical {
   private String producator;
   private Integer pret;

    public InstrumentMuzical() {
    }

    public InstrumentMuzical(String producator, Integer pret) {
        this.producator = producator;
        this.pret = pret;
    }

    public String getProducator() {
        return producator;
    }

    public void setProducator(String producator) {
        this.producator = producator;
    }

    public Integer getPret() {
        return pret;
    }

    public void setPret(Integer pret) {
        this.pret = pret;
    }
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof Chitara)) {
            return false;
        }

        Chitara other = (Chitara) obj;

        return Objects.equals(this.getProducator(), other.getProducator())
                && this.getPret() == other.getPret();

    }
    @Override
    public int hashCode() {
        return System.identityHashCode(this);
    }
    @Override
    public String toString() {
        return "InstrumentMuzical{" +
                "producator='" + producator + '\'' +
                ", pret=" + pret +
                '}';
    }
}
