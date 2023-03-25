package exercitiul2;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;




import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

public class Main {



    public static void main(String[] args) throws IOException {

        File inputFile = new File("src/main/resources/mobilier.json");
        ObjectMapper objectMapper = new ObjectMapper();
        List<Mobilier> mobilierList = new ArrayList<>();
       // byte[] jsonData = Files.readAllBytes(inputFile.toPath());
        mobilierList = objectMapper.readValue(inputFile, new TypeReference<List<Mobilier>>(){});
        boolean ok =true;
        int opt;
        do{
            System.out.println("a) Citește datele despre piesele de mobilier din fișierul mobilier.json într-o listă de piese\n" +
                    "de mobilier (List<Mobilier>) și le afișează\n" +
                    "b) Afişează elementele de mobilier din colecție şi plăcile care le compun\n" +
                    "c) Afişează caracteristicile plăcilor care compun o anumită piesă de mobilier\n" +
                    "d) Afișează estimativ numărul colilor de pal necesare pentru realizarea unui anumit corp\n" +
                    "de mobile știind că o coală de pal are dimensiunea 2800 x 2070 mm (pentru simplitate\n" +
                    "se va ţine cont doar de arie, nu şi de posibilitatea de a realiza tăieturile) \n");
            System.out.println("Optiunea aleasa : ");
            Scanner sc = new Scanner(System.in);
            opt = sc.nextInt();
            switch (opt)
            {
                case 0:
                System.exit(0);
                case 1:

                    for (Mobilier mobilier : mobilierList) {
                        System.out.println("Mobilier: " + mobilier.getNume());
                        System.out.println("*********************************************************************************************");
                        //afișăm informațiile despre fiecare placă din mobilier
                        for (Placa placa : mobilier.getPlaci()) {
                            System.out.println("Placă: " + placa.getDescriere());
                            System.out.println("Lungime: " + placa.getLungime());
                            System.out.println("Lățime: " + placa.getLatime());
                            System.out.println("Orientare: " + placa.getOrientare().toString().toUpperCase());
                            System.out.println("Canturi: " + Arrays.toString(placa.getCanturi()));
                            System.out.println("Număr bucăți: " + placa.getNr_bucati());
                            System.out.println("*********************************************************************************************");

                        }

                        System.out.println();
                        System.out.println("*********************************************************************************************");
                    }
                    break;
                case 2:
                   // List<Mobilier> mobiliere = mapper.readValue(jsonData, new TypeReference<List<Mobilier>>(){});

                    for (Mobilier mob :  mobilierList) {
                        System.out.println("Mobilier: " + mob.getNume());
                        System.out.println("Placi:");
                        for (Placa placa : mob.getPlaci()) {
                            System.out.println("- Descriere: " + placa.getDescriere());
                            System.out.println("  Lungime: " + placa.getLungime());
                            System.out.println("  Latime: " + placa.getLatime());
                            System.out.println("  Orientare: " + placa.getOrientare());
                            System.out.print("  Canturi: ");
                            for (Boolean cant : placa.getCanturi()) {
                                System.out.print(cant + " ");
                            }
                            System.out.println();
                            System.out.println("  Nr buc: " + placa.getNr_bucati());
                        }
                        System.out.println();
                    }
                    break;
                case 3:
                    System.out.println("Pentru mobilierul " + Mobilier.getNume() + " sunt necesare urmatoarele placi:");
                    List<Placa> placi = Mobilier.getPlaci();
                    for (Placa placa : placi) {
                        System.out.println("Descriere: " + placa.getDescriere());
                        System.out.println("Lungime: " + placa.getLungime());
                        System.out.println("Latime: " + placa.getLatime());
                        System.out.println("Orientare: " + placa.getOrientare());
                        System.out.print("Canturi: ");
                        for (Boolean cant : placa.getCanturi()) {
                            System.out.print(cant + " ");
                        }
                        System.out.println();
                        System.out.println("Numar bucati: " + placa.getNr_bucati());
                        System.out.println();
                    }
                    break;
                case 4:
                    for(Mobilier mobilier: mobilierList)
                    {
                        int nrPlaci = Mobilier.getPlaci().size();
                        int arie=0;
                        for (Placa placa : Mobilier.getPlaci())
                        {
                            int lungime = placa.getLungime();
                            int latime= placa.getLatime();
                            arie += lungime*latime;
                        }
                        int numarColi = (int) Math.ceil((double) arie/ (2800 * 2070));
                        System.out.println("Pentru corpul de mobilier " + mobilier.getNume() + " sunt necesare " + numarColi + " coli de pal.");
                    }
                    break;
            }
        }while (ok==true);
    }
}

