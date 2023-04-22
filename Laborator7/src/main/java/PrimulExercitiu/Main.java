package PrimulExercitiu;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void scriere(Map<Integer,Carte> carti) {
        try {
            ObjectMapper mapper=new ObjectMapper();
            FileOutputStream file =new FileOutputStream("src/main/resources/carti.json");
            mapper.writeValue(file,carti);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws IOException {
        FileInputStream fileInputStream = new FileInputStream("src/main/resources/carti.json");

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
     //   objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        Map<Integer,Carte> carti= objectMapper.readValue(fileInputStream, new TypeReference<HashMap<Integer,Carte>>() {
        });
        var entryset=carti.entrySet();
        entryset.stream().forEach(System.out::println);
       carti.remove(1);
        System.out.println("*******************************************************************************");
        entryset.stream().forEach(System.out::println);
        System.out.println("*******************************************************************************");

        carti.putIfAbsent(1, new Carte("Java","Profesor Robu",2023));
        entryset.stream().forEach(System.out::println);
        scriere(carti);
//        Să se creeze o colecție Set<Carte> care extrage din colecția Map cărțile autorului
//        Yual Noah Harari. Se va utiliza Stream API şi colectori. Se va afișa colecția creată cu
//        ajutorul metodei forEach.
        System.out.println("*******************************************************************************");

        Set<Carte> autorCarti = carti.values().stream()
                .filter(carte -> carte.autorul().equalsIgnoreCase("Yuval Noah Harari"))
                .collect(Collectors.toSet());

        autorCarti.forEach(System.out::println);
        System.out.println("*******************************************************************************");

        autorCarti.stream().sorted(Comparator.comparing(Carte::titlul)).forEach(System.out::println);
        Optional<Set<Carte>> opt = Optional.ofNullable(autorCarti);
        System.out.println("*******************************************************************************");

        if(opt.isPresent())
        {
            System.out.println(autorCarti.stream().sorted(Comparator.nullsFirst(Comparator.comparing(Carte::anul))).findFirst());
        }

    }
}
