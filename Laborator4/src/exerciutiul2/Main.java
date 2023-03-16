package exerciutiul2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static void Serializare(Object o,String fis)
    {
        try {
           // fis= "src/exerciutiul2/echipamente.bin";
            FileOutputStream f = new FileOutputStream(fis);
            ObjectOutputStream oos = new ObjectOutputStream(f);
            oos.writeObject(o);
            oos.close();
            f.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    static Object Deserializare(String fis) {
        try {
         //   fis= "src/exerciutiul2/echipamente.bin";
            FileInputStream f = new FileInputStream(fis);
            ObjectInputStream ois = new ObjectInputStream(f);
            Object o=ois.readObject();
            ois.close();
            f.close();
            return o;
        }
        catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void main(String[] args) throws IOException {
        List<Echipamente> echipamentes= new ArrayList<Echipamente>();
        Echipamente[] e = new Echipamente[6];
        String path = "src/exerciutiul2/echipamente.txt";
        BufferedReader cit;
        cit = new BufferedReader(new InputStreamReader(new FileInputStream(path)));
        String linie;
        String [] carcteristici ;
        int nr_inv;
        String denumire;
        String zona_mag;
        double pret;
        Stare stare;
        Scanner scanner = new Scanner(System.in);
        while (cit.ready())
        {
            linie= cit.readLine();
            carcteristici = linie.split(";");
             denumire = carcteristici[0];
             nr_inv = Integer.parseInt(carcteristici[1]);
             zona_mag=carcteristici[3];
             pret = Double.parseDouble(carcteristici[2]);
            stare = Stare.valueOf(carcteristici[4]);
         echipamentes.add(new Echipamente(denumire,nr_inv,pret,zona_mag,stare));

            Echipamente ech1 = new Echipamente(denumire,nr_inv,pret,zona_mag,stare);
            if(linie.contains("imprimanta"))
            {
                int ppm = Integer.parseInt(carcteristici[6]);
                String rezolutie = carcteristici[7];
                int p_car=Integer.parseInt(carcteristici[8]);
                ModTiparire modTiparire= ModTiparire.valueOf(carcteristici[9].toLowerCase());
                echipamentes.add(new Imprimante(denumire,nr_inv,pret,zona_mag,stare,ppm,rezolutie,p_car,modTiparire));

            }
            if(linie.contains("copiator")){
                int p_ton = Integer.parseInt(carcteristici[6]);
                FormatCopiere formatCopiere = FormatCopiere.valueOf(carcteristici[7]);
                echipamentes.add(new Copiatoare(denumire,nr_inv,pret,zona_mag,stare,p_ton,formatCopiere));
            }
            if(linie.contains("sistem de calcul"))
            {
                String tip_m= carcteristici[6];
                double vit_mon =Double.parseDouble(carcteristici[7]);
                String c_hdd= carcteristici[8];
                SistemOperare sistemOperare = SistemOperare.valueOf(carcteristici[9]);
                echipamentes.add(new SistemeCalcul(denumire,nr_inv,pret,zona_mag,stare,tip_m,vit_mon,c_hdd,sistemOperare));

            }

        }

        boolean ok =  true;
        do {
            System.out.println("1.Afişarea tuturor echipamentelor\n2. Afişarea imprimantelor\n3. Afişarea copiatoarelor\n4. Afişarea sistemelor de calcul\n5. Modificarea stării în care se află un echipament\n6.Setarea unui anumit mod de scriere pentru o imprimantă\n7. Setarea unui format de copiere pentru copiatoare\n8. Instalarea unui anumit sistem de operare pe un sistem de calcul\n9. Afişarea echipamentelor vândute\n10. Să se realizeze două metode statice pentru serializarea / deserializarea colecției de  obiecte în fișierul echip.bin )");
            System.out.println("0.Exit");
            System.out.println("Introd opt: ");
            Scanner sc = new Scanner(System.in);
            int opt = sc.nextInt();
            switch (opt)
            {
                case 0:
                    System.exit(1);
                    break;
                case 1:
                    System.out.println("*******************************************************************************************************************************************************************************************************************************");

                    System.out.println("Imprimante: ");
                    System.out.println("");
                    for( Echipamente echip : echipamentes)
                        if (echip instanceof  Imprimante)
                            System.out.println(echip);
                    System.out.println("");
                    System.out.println("*******************************************************************************************************************************************************************************************************************************");
                    System.out.println("Copiatoare: ");

                    System.out.println("");
                    for(Echipamente echip : echipamentes){
                        if( echip instanceof  Copiatoare)
                            System.out.println(echip);
                    }
                    System.out.println("");
                    System.out.println("*******************************************************************************************************************************************************************************************************************************");
                    System.out.println("Sisteme de calcul");
                    System.out.println("");
                    for (Echipamente echip :echipamentes)
                    {
                        if( echip instanceof SistemeCalcul)
                            System.out.println(echip);
                    }
                    System.out.println("");
                    System.out.println("*******************************************************************************************************************************************************************************************************************************");

                    break;
                case 2:
                    System.out.println("*******************************************************************************************************************************************************************************************************************************");

                    System.out.println("Imprimante: ");
                    System.out.println("");
                    for( Echipamente echip : echipamentes)
                        if (echip instanceof  Imprimante)
                            System.out.println(echip);
                    System.out.println("");
                    System.out.println("*******************************************************************************************************************************************************************************************************************************");

                    break;
                case 3:
                    System.out.println("*******************************************************************************************************************************************************************************************************************************");
                    System.out.println("Copiatoare: ");

                    System.out.println("");
                    for(Echipamente echip : echipamentes){
                        if( echip instanceof  Copiatoare)
                            System.out.println(echip);
                    }
                    System.out.println("");
                    System.out.println("*******************************************************************************************************************************************************************************************************************************");

                    break;
                case 4:
                    System.out.println("Sisteme de calcul");
                    System.out.println("");
                    for (Echipamente echip :echipamentes)
                    {
                        if( echip instanceof SistemeCalcul)
                            System.out.println(echip);
                    }
                    System.out.println("");
                    System.out.println("*******************************************************************************************************************************************************************************************************************************");

                    break;
                case 5:

                    System.out.println("Cititi denumirea echipamentului caruia doriti sa ii schimbati starea: ");
                    String nume = scanner.nextLine();

                    for (Echipamente echipament : echipamentes) {
                        if (echipament.getDenumire().equalsIgnoreCase(nume)) {
                            System.out.println("Starea curenta a echipamentului " + echipament.getDenumire() + " este " + echipament.getStare());

                            System.out.print("Cititi modificarea starii (0 - achizitionat, 1 - expus, 2 - vandut): ");
                            int alegere = scanner.nextInt();
                            switch (alegere) {
                                case 0:
                                    echipament.setStare(Stare.achizitionat);
                                    break;
                                case 1:
                                    echipament.setStare(Stare.expus);
                                    break;
                                case 2:
                                    echipament.setStare(Stare.vandut);
                                    break;
                                default:
                                    System.out.println("Optiunea introdusa nu este valida.");
                                    break;
                            }

                            System.out.println("Starea echipamentului " + echipament.getDenumire() + " a fost modificata cu succes in " + echipament.getStare());
                            break;
                        }
                    }

                    break;
                case 6:
                    System.out.println("Alegeti denumirea imprimatei careia doriti sa ii schimbati modul de scriere");
                    String imp= scanner.nextLine();
                    for (Echipamente echip :echipamentes )
                    {
                        if (echip instanceof  Imprimante) {
                            if (echip.getDenumire().equalsIgnoreCase(imp)) {

                                System.out.println("Modul curent de scrie al echipamentului " + echip.getDenumire() + " este "+ ((Imprimante) echip).getModTiparire());
                                System.out.print("Cititi modificarea modului de tiparire (0 - color, 1 - albsinegru) ");
                                int alegere = scanner.nextInt();
                                switch (alegere) {
                                    case 0:
                                        ((Imprimante) echip).setModTiparire(ModTiparire.color);
                                        break;
                                    case 1:
                                        ((Imprimante) echip).setModTiparire(ModTiparire.albsinegru);
                                        break;

                                    default:
                                        System.out.println("Optiunea introdusa nu este valida.");
                                        break;
                                }
                                System.out.println("Modul de tiparire al echipamentului "+ echip.getDenumire() + "a fost schimbat in "+((Imprimante) echip).getModTiparire());

                            }
                        }
                    }

                    break;
                case 7:
                    System.out.println("Alegeti denumirea copiatorului careia doriti sa ii schimbati fromatul de copiere");
                    String cop= scanner.nextLine();
                    for (Echipamente echip :echipamentes )
                    {
                        if (echip instanceof  Copiatoare) {
                            if (echip.getDenumire().equalsIgnoreCase(cop)) {

                                System.out.println("Formatul curent de scrie al echipamentului " + echip.getDenumire() + " este "+ ((Copiatoare) echip).getFormatCopiere());
                                System.out.print("Cititi modificarea formatului de tiparire (0 - A3, 1 - A4) ");
                                int alegere = scanner.nextInt();
                                switch (alegere) {
                                    case 0:
                                        ((Copiatoare) echip).setFormatCopiere(FormatCopiere.A3);
                                        break;
                                    case 1:
                                        ((Copiatoare) echip).setFormatCopiere(FormatCopiere.A4);
                                        break;

                                    default:
                                        System.out.println("Optiunea introdusa nu este valida.");
                                        break;
                                }
                                System.out.println("");
                                System.out.println("Formatul de tiparire al echipamentului "+ echip.getDenumire() + "a fost schimbat in "+((Copiatoare) echip).getFormatCopiere());
                                System.out.println("");
                            }
                        }
                    }
                    break;
                case 8:
                    System.out.println("Alegeti instalarea unui anumit sistem de operare pe un sistem de calcul  pe care doriti sa il schimbati ");
                    String sis= scanner.nextLine();
                    for (Echipamente echip :echipamentes )
                    {
                        if (echip instanceof  SistemeCalcul) {
                            if (echip.getDenumire().equalsIgnoreCase(sis)) {

                                System.out.println("Sis de operare curent  al echipamentului " + echip.getDenumire() + " este "+ ((SistemeCalcul) echip).getSistemOperare());
                                System.out.print("Cititi modificarea sistemului de operare (0 -windows, 1 - linux) ");
                                int alegere = scanner.nextInt();
                                switch (alegere) {
                                    case 0:
                                        ((SistemeCalcul) echip).setSistemOperare(SistemOperare.windows);
                                        break;
                                    case 1:
                                        ((SistemeCalcul) echip).setSistemOperare(SistemOperare.linux);
                                        break;

                                    default:
                                        System.out.println("Optiunea introdusa nu este valida.");
                                        break;
                                }
                                System.out.println("");
                                System.out.println("Sis de operare al echipamentului "+ echip.getDenumire() + "a fost schimbat in "+ ((SistemeCalcul) echip).getSistemOperare());
                                System.out.println("");
                            }
                        }
                    }
                    break;
                case 9:
                    System.out.println("Echipamentele vandute sunt: ");
                    String str="vandut";
                    for( Echipamente echp : echipamentes)
                    {
                        if((echp.getStare().equals(Stare.vandut)))
                        {
                            System.out.println(echp);
                        }
                    }
                    break;
                case 10:
                    Serializare(echipamentes,"src/exerciutiul2/echipamente.bin");
                    System.out.println("Serializare finalizata cu succes!");
                    System.out.println("Deserealizarea arata: ");
                    System.out.println(" ");
                    List<Echipamente>q;
                    q=(List<Echipamente>)Deserializare("src/exerciutiul2/echipamente.bin");
                    for(Echipamente echip : q)
                        System.out.println(echip);
                    break;

            }

        }while (ok==true);



    }
}
