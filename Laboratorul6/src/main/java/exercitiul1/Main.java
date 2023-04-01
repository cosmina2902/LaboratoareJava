package exercitiul1;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void scriere(List<Angajat> lista) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            File file = new File("src/main/resources/anagajati.json");
            mapper.writeValue(file, lista);
            mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Angajat> citire() {
        try {
            File file = new File("src/main/resources/anagajati.json");
            ObjectMapper mapper = new ObjectMapper();
            mapper.registerModule(new JavaTimeModule());
            // ObjectMapper disable = mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
            List<Angajat> angajati = mapper.readValue(file, new TypeReference<List<Angajat>>() {
            });
            return angajati;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        List<Angajat> angajats= new ArrayList<>();
        List<Angajat> angajati = citire();
        angajati.forEach(System.out::println);
        System.out.println("***************************************************************************************");
        System.out.println("Angajatii care au salariul peste 2500 lei sunt: ");
        System.out.println("");
        angajati.stream().filter((angajat -> angajat.getSalariul() > 2500)).forEach(System.out::println);
        System.out.println("");
        int anCurent = LocalDate.now().getYear();

        List<Angajat> angajatiConducereAprilieAnulTrecut = angajati.stream()
                .filter(angajat -> angajat.getPost().contains("sef") || angajat.getPost().contains("director"))
                .filter(angajat -> angajat.getData_angajarii().getMonthValue() == 4 && angajat.getData_angajarii().getYear() == anCurent - 1)
                .collect(Collectors.toList());


        System.out.println("Angajatii din luna aprilie a anului trecut care au functie de conducere sunt:");
        System.out.println("");
        angajatiConducereAprilieAnulTrecut.forEach(System.out::println);
        System.out.println("**********************************************************************************************");
        System.out.println("Angajatii  care nu au functie de conducere sunt:");

        angajati.stream().filter(angajat -> !(angajat.getPost().contains("sef")) && !angajat.getPost().contains("director"))
                .sorted(Comparator.comparingDouble(Angajat::getSalariul).reversed()).forEach(System.out::println);
        System.out.println("Numele angajatilor scris cu majuscule sunt: ");
        angajati.stream().map(angajat -> angajat.getNume().toUpperCase()).collect(Collectors.toList()).forEach(System.out::println);
        System.out.println("*******************************************************************************************");
        System.out.println("Salarii mai mici de 3000 de lei sunt: ");
        angajati.stream().filter(angajat -> angajat.getSalariul()<3000).map(Angajat::getSalariul).forEach(System.out::println);
        System.out.println("**************************************************************************************************");
        Optional<Angajat> primulangj=angajati.stream()
                .sorted((a1,a2)->a1.getData_angajarii().compareTo(a2.getData_angajarii())).findFirst();
        if(primulangj.isPresent())
            System.out.println("Primul angajat din firma este "+primulangj.get());
        else
            System.out.println("Nu avem angajati in firma");
        System.out.println("**************************************************************************************************");

        System.out.println("SAlariile din frima sunt urmatoarele: ");

        DoubleSummaryStatistics salarii = angajati.stream()
                .mapToDouble(Angajat::getSalariul).summaryStatistics();
        System.out.println("Salariul minim este : "+salarii.getMin());
        System.out.println("Salariul mediu este : "+salarii.getAverage());
        System.out.println("Salariul maxim este : "+salarii.getMax());
        System.out.println("**************************************************************************************************");
        Optional<Angajat > fiindIon=angajati.stream()
                .filter(angajat -> angajat.getNume().contains("Ion")).findAny();
        fiindIon.ifPresentOrElse(ion-> System.out.println("Firma are cel putin un Ion"),()->
                System.out.println("In firma nu exista niciun Ion"));
        System.out.println("**************************************************************************************************");
        int an_trecut = LocalDate.now().getYear()-1;
        //System.out.println(an_trecut);
        LocalDate Iuni_pred = LocalDate.parse(an_trecut+"-06-01");
        LocalDate August_pred = LocalDate.parse(an_trecut+"-08-31");
         int nr = (int)angajati.stream().filter(angajat -> angajat.getData_angajarii().
                 isAfter(Iuni_pred) && angajat.getData_angajarii().isBefore(August_pred)).count();
        System.out.println("Numarul de angajatii care s-au angajat in vara anului trecut sunt: "+nr );
//        LocalDate iunie = LocalDate.now().minusYears(1).withMonth(6).withDayOfMonth(1);
//        LocalDate august = LocalDate.now().minusYears(1).withMonth(8).withDayOfMonth(31);
//
    }
}
