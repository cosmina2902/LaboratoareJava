package exercitiul1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Ex1 {
    public static void main(String[] args) throws IOException {
        String fiser = "src/exercitiul1/in.txt";
        BufferedReader cit;
        cit = new BufferedReader(new InputStreamReader(new FileInputStream(fiser)));
        String linie;
        String[] cuvinte;
        int a, b, c;
        List<Parabola> parabolas = new ArrayList<Parabola>();

        double[] mijloc = new double[2];
        double[] miloc_static = new double[2];
        double [] hypot1 = new  double[2];
        double [] hypot2 = new  double[2];
        while ((linie = cit.readLine()) != null) {
            cuvinte = linie.split(",");
            a = Integer.parseInt(cuvinte[0]);
            b = Integer.parseInt(cuvinte[1]);
            c = Integer.parseInt(cuvinte[2]);
            parabolas.add(new Parabola(a, b, c));
            Parabola p1 = new Parabola(a, b, c);
            Parabola p2 = new Parabola(a, b, c);
            Parabola p3 = new Parabola(a, b, c);
            mijloc = p1.mijloculSegementParabola(p2);
            miloc_static = p3.MijlocSegment2Parabole(p1, p2);
            hypot1 = p1.LungimesegCuParabola(p2);
            hypot2=p2.lungimeSegment(p1,p3);
            System.out.println(hypot1[0]);

        }
        for (Parabola parabola : parabolas)
            System.out.println(parabola);

        System.out.printf("Cordonatele mij seg de dreapta care uneste varfu parabolei cu varfulu parabolei transmisa ca si parametru sunt  (%.2f, %.2f)\n",mijloc[0],mijloc[1]);
        System.out.printf("Coordonatele mijlocului segmentului de dreaptă care uneşte vârfurile celor două parabole sunt (%.2f, %.2f)\n", miloc_static[0], miloc_static[1]);



    }
}
