import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void afisarePersoanCUExcurii(Statement statement)
    {
        String sql = "SELECT * FROM persoane LEFT JOIN excursii ON persoane.id = excursii.id_persoana\n";
        try(ResultSet rs = statement.executeQuery(sql))
        {
            int curentId=3;
            while (rs.next())
            {
                int id_pers = rs.getInt("id_persoana");
                String nume=rs.getString("nume");
                int varsta = rs.getInt("varsta");
                int id_exc = rs.getInt("id_excursie");
                String dest = rs.getString("destinatie");
                LocalDate anul = LocalDate.parse(rs.getNString("anul"));
                if(id_pers!=curentId)
                {
                    System.out.println("        Persoana: " + nume + " " + varsta + " (ID: " + id_pers + ")");
                    curentId = id_pers;
                }
                System.out.println("     (Id-excursie: "+id_exc+") " + dest + " (" + anul + ")");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public static void afisare_tabela(Statement statement, String mesaj) {
        String sql
                ="select * from persoane";
        System.out.println("\n---"
                +mesaj
                +"---");
        try(ResultSet rs
                    =statement.executeQuery(sql)) {
            while (rs.next())
                System.out.println("id=" + rs.getInt(1) + ", nume=" + rs.getString(2) + ",varsta="
                        + rs.getInt(3));
        } catch (SQLException
                e) {
            e.printStackTrace();
        }
    }
    public static void adaugareAfter(Connection connection, String nume, int varsta)
    {
        String sql = "INSERT INTO persoane (nume, varsta) VALUES (?,?)";
        try (PreparedStatement ps = connection.prepareStatement(sql))
        {
            ps.setString(1,nume);
            ps.setInt(2,varsta);
            int nr_randuri=ps.executeUpdate();
            System.out.println("\nNumar randuri afectate de adaugare="+nr_randuri);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void adaugare(Connection connection, int id, String nume, int varsta) {
        String sql="insert into persoane values (?,?,?)";
        try(PreparedStatement ps=connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.setString(2, nume);
            ps.setInt(3, varsta);
            int nr_randuri=ps.executeUpdate();
            System.out.println("\nNumar randuri afectate de adaugare="+nr_randuri);
        } catch (SQLException e) {
            System.out.println(sql);
            e.printStackTrace();
        }
    }
    public static void afisareExcursieDupaNume(Statement statement, String nume) {

        String sql = "SELECT excursii.id_excursie, excursii.destinatie, excursii.anul " +
                "FROM excursii " +
                "JOIN persoane ON excursii.id_persoana = persoane.id " +
                "WHERE persoane.nume = '" + nume + "'";
        try (ResultSet rs = statement.executeQuery(sql)) {
            while (rs.next()) {
                int id_exc = rs.getInt("id_excursie");
                String dest = rs.getString("destinatie");
                LocalDate anul = LocalDate.parse(rs.getString("anul"));

                System.out.println("(Id-excursie: " + id_exc + ") " + dest + " (" + anul + ")");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    private static void afisarePersoaneDupaDestinatie(Statement statement,Connection connection, String destinatie) {
        String sql = "SELECT * FROM persoane JOIN excursii " +
                "ON persoane.id=excursii.id_persoana " +
                "WHERE excursii.destinatie = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, destinatie);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String nume = rs.getString("nume");
                int varsta = rs.getInt("varsta");
                System.out.println("Persoana: " + nume + " are id: " + id + " varsta " + varsta);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public  static void afisarePersoaneDupaAnExcursie(Statement statement, Connection connection,LocalDate an)
    {
        String sql = "SELECT * FROM persoane JOIN excursii " +
                "ON persoane.id=excursii.id_persoana " +
                "WHERE excursii.anul = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, String.valueOf(an));
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String nume = rs.getString("nume");
                int varsta = rs.getInt("varsta");
                System.out.println("In anul "+an+" a fost in excursie ");
                System.out.println("Persoana: " + nume + " care are id: " + id + " si varsta " + varsta);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void stergeExcursie(Connection connection, int id_excursie) {
        String sql = "DELETE FROM excursii WHERE id_excursie = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id_excursie);
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Excursia cu id-ul " + id_excursie + " a fost stearsa.");
            } else {
                System.out.println("Nu a fost gasita nicio excursie cu id-ul " + id_excursie + ".");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void adaugareExcursii(Connection connection, int id_pers, String destinatie, LocalDate anul) {
        String selectQuery = "SELECT * FROM persoane WHERE id = ?";

        try (PreparedStatement selectStatement = connection.prepareStatement(selectQuery)) {
            selectStatement.setInt(1, id_pers);
            ResultSet resultSet = selectStatement.executeQuery();

            if (resultSet.next()) {
                // Persoana există, inserăm o nouă înregistrare în tabela excursii
                String insertQuery = "INSERT INTO excursii (id_persoana, destinatie, anul) VALUES (?, ?, ?)";
                PreparedStatement insertStatement = connection.prepareStatement(insertQuery);
                insertStatement.setInt(1, id_pers);

                insertStatement.setString(2, destinatie);
                insertStatement.setString(3, anul.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
                int rowsAffected = insertStatement.executeUpdate();
                System.out.println("Excursia a fost adăugată cu succes!");
            } else {
                // Persoana nu există, afișăm un mesaj corespunzător
                System.out.println("Persoana cu id-ul " + id_pers + " nu există în baza de date.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void stergePersoana(Statement statement, int id) {
        String sql = "DELETE FROM excursii WHERE id_persoana = " + id;
        try {
            statement.executeUpdate(sql);
            sql = "DELETE FROM persoane WHERE id = " + id;
            statement.executeUpdate(sql);
            System.out.println("S-a sters persoana cu id-ul " + id + " si toate excursiile sale.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //    Adăugarea unei excursii în tabela excursii. Înainte de a efectua adăugarea se va
//    verifica dacă persoana căreia îi aparține excursia a fost introdusă în tabela
//    persoane. Dacă nu a fost introdusă se va afișa un mesaj corespunzător. Datele
//    excursiei se vor prelua de la tastatură.
    public static void main(String[] args) throws SQLException {
      String url = "jdbc:mysql://localhost:3306/lab8?user=root";


        try {
            Connection connection = DriverManager.getConnection(url, "root", "root");
            Statement statement = connection.createStatement();
            afisare_tabela(statement, "Continut initial tabela persona");
         //adaugare(connection, 4, "Dana", 23);
           afisare_tabela(statement, "Dupa adaugare");
            System.out.println("Adaugam inca o persoana nu increment");
              // adaugareAfter(connection,"Dana",23);
          afisare_tabela(statement, "Dupa adaugare");
            System.out.println("Adaugam excursii");
            adaugareExcursii(connection,6,"Bali", LocalDate.parse("2023-04-26"));
            System.out.println("Afișarea tuturor persoanelor şi pentru fiecare persoană a excursiilor în care a fost" );
           afisarePersoanCUExcurii(statement);
            System.out.println("*******************Afișarea excursiilor în care a fost o persoană al cărei nume se citește de la tastatură **********************************");
            Scanner scanner = new Scanner(System.in);
            System.out.println("Introduceti numele: ");
            String nume = scanner.nextLine();
            System.out.println(nume+" a fost in urmatoarele excursii");
            afisareExcursieDupaNume(statement,nume);
            System.out.println("********Afișarea tuturor persoanelor care au vizitat o anumita destinație******");
            System.out.println("Introduceti destinatia: ");
            String dest = scanner.nextLine();
            afisarePersoaneDupaDestinatie(statement,connection,dest);
            System.out.println("*****. Afișarea persoanelor care au făcut excursii într-un an introdus ****");
            afisarePersoaneDupaAnExcursie(statement,connection, LocalDate.parse("2023-05-04"));
          //  stergeExcursie(connection,1);
            //stergePersoana(statement,4);
           // afisare_tabela(statement,"Dupa stergere");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }


    }


}
