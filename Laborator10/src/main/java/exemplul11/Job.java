package exemplul11;

public class Job {
    private String firma;
    private String functia;

    public String getFirma() {
        return firma;
    }

    public void setFirma(String firma) {
        this.firma = firma;
    }

    public String getFunctia() {
        return functia;
    }

    public void setFunctia(String functia) {
        this.functia = functia;
    }

    public String toString() {
        return firma + ", " + functia;
    }
}
