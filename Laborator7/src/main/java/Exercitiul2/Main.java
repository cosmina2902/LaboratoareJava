package Exercitiul2;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static Exercitiul2.TipChitara.*;
import static Exercitiul2.TipTobe.*;

public class Main {
    public static Set<InstrumentMuzical> citire() {
        try {
            File file = new File("src/main/resources/instrumente.json");
            ObjectMapper mapper = new ObjectMapper();
            Set<InstrumentMuzical> instrumentMuzicals = mapper
                    .readValue(file, new TypeReference<Set<InstrumentMuzical>>() {
                    });
            return instrumentMuzicals;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void scriere(Set<InstrumentMuzical> instrumentMuzicals) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            FileOutputStream file = new FileOutputStream("src/main/resources/instrumente.json");
            mapper.activateDefaultTyping(mapper.getPolymorphicTypeValidator());
            mapper.writeValue(file, instrumentMuzicals);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Set<InstrumentMuzical> instrumente = new HashSet<InstrumentMuzical>();
        InstrumentMuzical instrumentMuzical = new Chitara("Ceva", 800, ELECTRICA, 12);
        InstrumentMuzical instrumentMuzical1 = new Chitara("Mamaliga", 3500, ACUSTICA, 2);
        InstrumentMuzical instrumentMuzical2 = new Chitara("Altceva", 580, CLASICA, 25);
        instrumente.add(instrumentMuzical);
        instrumente.add(instrumentMuzical1);
        instrumente.add(instrumentMuzical2);
        InstrumentMuzical instrumentMuzical3 = new SetTobe("Mihai", 951, ACUSTICE, 7, 9);
        InstrumentMuzical instrumentMuzical4 = new SetTobe("Gica", 4000, ELECTRONICE, 2, 10);
        InstrumentMuzical instrumentMuzical5 = new SetTobe("Costica", 369, ACUSTICE, 5, 6);
        instrumente.add(instrumentMuzical3);
        instrumente.add(instrumentMuzical4);
        instrumente.add(instrumentMuzical5);
        instrumente.stream().forEach(System.out::println);
        scriere(instrumente);
        System.out.println("*********************************************************************************");
        Set<InstrumentMuzical> newSet = citire();
        newSet.forEach(System.out::println);

        Chitara c1 = new Chitara("Mamaliga", 700, ACUSTICA, 2);
        if (newSet.equals(c1)) {
            newSet.add(c1);
            System.out.println(c1 + " a fost adaugat in colectie");
        } else {
            System.out.println(c1 + " nu poate fi adaugat in colectie pentru ca exista deja");
        }
        System.out.println("*********************************************************************************");

        newSet.forEach(System.out::println);
        System.out.println("*********************************************************************************");
        newSet.removeIf(instr ->instr.getPret()>3000 );
        newSet.stream().forEach(System.out::println);
        System.out.println("*********************************************************************************");
        newSet.stream().filter(i->i instanceof Chitara).forEach(System.out::println);
        System.out.println("*********************************************************************************");
        newSet.stream().filter(i->i.getClass()==SetTobe.class).forEach(System.out::println);
        System.out.println("*********************************************************************************");

        Optional<InstrumentMuzical> opt = newSet.stream()
                .filter(i->i instanceof Chitara)
                .sorted((a,b)->((Chitara) b).getNrCorzi()-((Chitara) a).getNrCorzi())
                .findFirst();
        if(opt.isPresent())
            System.out.println(opt+"\n");
        System.out.println("*********************************************************************************");
        newSet.stream().filter(i->i instanceof SetTobe)
                .filter(instrument->((SetTobe) instrument).getTipTobe()==ACUSTICE )
                .sorted((a,b)->((SetTobe) a).getNr_tobe()-((SetTobe) b).getNr_tobe())
                .forEach(System.out::println);
    }
}


