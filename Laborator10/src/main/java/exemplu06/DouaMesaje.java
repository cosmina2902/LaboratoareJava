package exemplu06;

public class DouaMesaje {
    private String mesaj1;
    private String mesaj2;
    public DouaMesaje(){}
    public String getMesaj1() {
        return mesaj1;
    }
    public void setMesaj1(String mesaj1) {
        this.mesaj1 = mesaj1;
    }
    public String getMesaj2() {
        return mesaj2;
    }
    public void setMesaj2(String mesaj2) {
        this.mesaj2 = mesaj2;
    }
    @Override
    public String toString() {
        return mesaj1 + ", " + mesaj2;
    }
}
