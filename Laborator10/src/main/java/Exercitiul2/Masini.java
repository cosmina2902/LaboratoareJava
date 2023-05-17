package Exercitiul2;

public class Masini {
    private String NumarInmatriculare;
    private String Marca;
    private String anFabricatie;
    private String Culoare;
    private Integer NumarKm;


    public String getNumarInmatriculare() {
        return NumarInmatriculare;
    }

    public void setNumarInmatriculare(String numarInmatriculare) {
        NumarInmatriculare = numarInmatriculare;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String marca) {
        Marca = marca;
    }

    public String getAnFabricatie() {
        return anFabricatie;
    }

    public void setAnFabricatie(String anFabricatie) {
        this.anFabricatie = anFabricatie;
    }

    public String getCuloare() {
        return Culoare;
    }

    public void setCuloare(String culoare) {
        Culoare = culoare;
    }

    public Integer getNumarKm() {
        return NumarKm;
    }

    public void setNumarKm(Integer numarKm) {
        NumarKm = numarKm;
    }

    @Override
    public String toString() {
        return
                "NumarInmatriculare='" + NumarInmatriculare + ' ' +
                ", Marca='" + Marca + ' ' +
                ", anFabricatie='" + anFabricatie + ' ' +
                ", Culoare='" + Culoare +" "+
                ", NumarKm='" + NumarKm ;
    }
}
