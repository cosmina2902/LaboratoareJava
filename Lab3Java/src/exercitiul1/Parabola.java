package exercitiul1;

public class Parabola {
    private int a;
    private  int b;
    private  int c;

    public Parabola(int a, int b,int c)
    {
        this.a=a;
        this.b=b;
        this.c=c;
    }


    public int getA() {
        return a;
    }
    public void setA(int a){this.a=a;}

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }

    public String toString(){
        return "f(x)= "+ a +"x^2 + "+b+"x+ "+c;
    }
    public double[] getVertex() {
        double x = -getB() / (2.0 * getA());
        double y = -(b * b - 4 * a * c) / (4.0 * a);
        return new double[] {x, y};
    }
    public static double [] mijloculSegementParabola(Parabola parabola)
    {
        double[] varf = parabola.getVertex();
        double x1 = varf[0];
        double y1 = varf[1];

        double[] parabolaVertex = parabola.getVertex();
        double x2 = parabolaVertex[0];
        double y2 = parabolaVertex[1];

        double MijlocX = (x1 + x2) / 2.0;
        double MijlocY = (y1 + y2) / 2.0;

        return new double[] {MijlocX, MijlocY};
    }
    public double [] MijlocSegment2Parabole(Parabola p1, Parabola p2)
    {
        double [] parabolavarf = p1.getVertex();
        double x1 = parabolavarf[0];
        double y1= parabolavarf[1];

        double [] parabolavarf2 = p2.getVertex();
        double x2= parabolavarf2[0];
        double y2 = parabolavarf2[1];

        double mijlocX=(x1+x2)/2;
        double mijlocY=(y1+y2)/2;

        return  new double[]{mijlocX,mijlocY};
    }
    public  double [] LungimesegCuParabola(Parabola p) {
       double [] varf = p.getVertex();
       double x1=varf[0];
        double y1=varf[1];

        double[] parabolaVertex = p.getVertex();
        double x2 = parabolaVertex[0];
        double y2 = parabolaVertex[1];
        return new double[]{Math.hypot(x2 - x1, y2 - y1)};

    }
    public  double [] lungimeSegment(Parabola p1, Parabola p2)
    {
        double x1 = -p1.getB() / (2 * p1.getA());
        double y1 = p1.getA() * Math.pow(x1, 2) + p1.getB() * x1 + p1.getC();
        double x2 = -p2.getB() / (2 * p2.getA());
        double y2 = p2.getA() * Math.pow(x2, 2) + p2.getB() * x2 + p2.getC();
        return new double[]{Math.hypot(x2 - x1, y2 - y1)};
    }

}

