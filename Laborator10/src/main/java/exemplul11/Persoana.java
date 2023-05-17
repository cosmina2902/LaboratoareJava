package exemplul11;

import org.springframework.beans.factory.annotation.Autowired;

public class Persoana {
    private String nume;
    private Job job;

    public Persoana() {
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public Job getJob() {
        return job;
    }

    @Autowired
    public void setJob(Job job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return nume + ", " + job;
    }
}

