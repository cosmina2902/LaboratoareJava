package Exercitiul2;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.time.LocalDate;
import java.util.List;

public class OperatiiBD {
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplateObject;
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }
    public void insert(String nrInmatriculare, String marca, String anulFabricatiei, String culoarea, String numarKm) {
        String SQL = "insert into masini (numarInmatriculare,marca,anulFabricatiei,culoarea,numarKm) values (?, ?,?,?,?)";
        jdbcTemplateObject.update( SQL, nrInmatriculare,marca,anulFabricatiei,culoarea,numarKm);

    }
    public void delete(String nrInmatriculare){
        String SQL = "delete from masini where numarInmatriculare = ?";
        jdbcTemplateObject.update(SQL, nrInmatriculare);
    }

    public Masini getMasini(String nrInmatriculare) {
        String SQL = "select * from masini where numarInmatriculare = ?";
       Masini masini = jdbcTemplateObject.queryForObject(SQL,
                new MasiniMapper(),new Object[]{nrInmatriculare});
        return masini;
    }
    public List<Masini> getListaMasini() {
        String SQL = "select * from masini";
        List <Masini> masinis = jdbcTemplateObject.query(SQL,new MasiniMapper());
        return masinis;
    }
    public List<Masini> getListaMasiniMarca(String marca) {
        String SQL = "select * from masini where marca = ?";
        List<Masini> masMarca = jdbcTemplateObject.query(SQL,  new BeanPropertyRowMapper<>(Masini.class),new Object[]{marca});

        return masMarca ;
    }
    public Integer getNRListaMasiniMarca(String marca) {
        String SQL = "select count(*) from masini where marca = ?";
        int nr = jdbcTemplateObject.queryForObject(SQL, Integer.class,new Object[]{marca});

        return nr ;
    }
    public List<Masini> getListaMasiniKm() {
        String SQL = "SELECT * FROM masini WHERE NumarKm < 100000";
        List<Masini> masMarca = jdbcTemplateObject.query(SQL, new MasiniMapper());
        return masMarca;
    }
    public List<Masini> getMasiniNoiDe5Ani() {
        LocalDate currentDate = LocalDate.now();
        int currentYear = currentDate.getYear();
        int maxYear = currentYear - 5;

        String SQL = "SELECT * FROM masini WHERE CAST(AnulFabricatiei AS UNSIGNED) > ?";
        List<Masini> masiniNoi = jdbcTemplateObject.query(SQL, new MasiniMapper(), maxYear);

        return masiniNoi;
    }


//    public void update(int id, int varsta){
//        String SQL = "update persoane set varsta = ? where id = ?";
//        jdbcTemplateObject.update(SQL, varsta, id);
//    }
//    public void delete(int id){
//        String SQL = "delete from persoane where id = ?";
//        jdbcTemplateObject.update(SQL, id);
//    }
}
