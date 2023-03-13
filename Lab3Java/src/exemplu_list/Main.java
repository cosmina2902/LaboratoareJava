package exemplu_list;

import java.util.ArrayList;
import java.util.List;

public class Main {
    static class Punct{
        private final int x;
        private final int y;
        public Punct(int x,int y)
        {
            super();
            this.x=x;
            this.y=y;
        }
        public String toString()
        {
            return " (" + x + "," +y + ")";
        }
    }
    public static void main(String[] args) {
        List<Punct> puncte = new ArrayList<Punct>();
        puncte.add(new Punct(1,2));
        puncte.add(new Punct(3,4));
        puncte.add(new Punct(5,6));
        System.out.println("Lista cotine urm puncte: ");
        for(Punct p : puncte)
        {
            System.out.println(p);
        }
        puncte.remove(0);
        System.out.println("DUpa stergerea prim elem lista contine: ");
        for(int i = 0;i<puncte.size();i++)
            System.out.println(puncte.get(i));
    }
}
