package exercitiul3;

public class Ex3 {
    public static void main(String[] args) {
        String sir = "Invatam programare Java cu drag si spor";
        String sub_sir ="prin intermediul Universitatii";

        String vedem = sir.substring(0,23)+" "+sub_sir+" "+sir.substring(24);
        StringBuilder sb = new StringBuilder(vedem);
        System.out.println(vedem);
        String stergere = String.valueOf(sb.delete(19,23));
        System.out.println(stergere);
    }
}
