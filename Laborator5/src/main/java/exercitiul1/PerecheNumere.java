package exercitiul1;

import java.util.ArrayList;
import java.util.List;

public class PerecheNumere {
    private int a;
    private int b;

    public PerecheNumere(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public PerecheNumere() {
        System.out.println("COnstructor fara parametri");
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }
    public void Liste(List<PerecheNumere> p)
    {
          p=new ArrayList<PerecheNumere>();
          p.add(new PerecheNumere(1,2));
          p.add(new PerecheNumere(5,7));
          p.add(new PerecheNumere(4,3));
    }
    public boolean   Fibbonaci(int num1,int num2)
    {
        int fib1 = 0, fib2 = 1, temp;
        while (fib2 < num2) {
            temp = fib2;
            fib2 += fib1;
            fib1 = temp;
        }
        return fib2 == num2 && fib1 == num1;
    }
    public int Cmmdc(int nr1, int nr2)
    {
        int rest;
        while (nr2 != 0 ){
            rest = nr1 % nr2;
            nr1= nr2;
            nr2 =rest;
        }
        return nr1;
    }
    public boolean Sumacif(int num1, int num2)
    {
        int sum1 = 0, sum2 = 0;
        while (num1 > 0) {
            sum1 += num1 % 10;
            num1 /= 10;
        }
        while (num2 > 0) {
            sum2 += num2 % 10;
            num2 /= 10;
        }
        return sum1 == sum2;
    }
    public boolean CifPare(int num1,int num2)
    {
        int count1=0,count2=0;
        while (num1>0)
        {
            if((num1%10)%2==0)
                count1++;
            num1/=10;
        }
        while (num2>0)
        {
            if((num2%10)%2==0)
                count2++;
            num2/=10;
        }
        return count1==count2;
    }
    @Override
    public String toString() {
        return "PerecheNumere{" +
                "a=" + a +
                ", b=" + b +
                '}';
    }
}
