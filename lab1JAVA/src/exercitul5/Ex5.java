package exercitul5;
import java.util.Random;

public class Ex5 {
    public static void main(String[] args) {
        Random rand = new Random();
        int nr = rand.nextInt(20);
        System.out.println("Numarul este " + nr);
        for(int i=0;i<9;i++)
            if(fibonacci(i) == nr)
            {
                System.out.println("Numarul " + nr+ " se gaseste in secventa fiboancci");
                return;
            }
        System.out.println("Numarul nu se gaseste in secventa fibonacci");
    }
    public static int fibonacci(int n)
    {
        if (n <= 1)
            return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
