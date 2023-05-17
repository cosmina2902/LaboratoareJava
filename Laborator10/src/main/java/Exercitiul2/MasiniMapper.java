package Exercitiul2;


import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
class MasiniMapper implements RowMapper<Masini> {
    public Masini mapRow(ResultSet rs, int rowNum) throws SQLException {
        Masini masini = new Masini();
        masini.setNumarInmatriculare(rs.getString(("numarInmatriculare")));
        masini.setMarca(rs.getString(("marca")));
        masini.setAnFabricatie(rs.getString(("anulFabricatiei")));
        masini.setCuloare(rs.getString(("culoarea")));
        masini.setNumarKm(rs.getInt(("numarKm")));
        return masini;
    }
}