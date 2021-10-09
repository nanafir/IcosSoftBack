package persistencia;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import logica.DataCatalogo;

public class CatalogoDao {

    private static final String SQL_SELECT = "SELECT id_catalogo, nombre_parametros, valor_parametro FROM CATALOGO";

    private static final String SQL_INSERT = "INSERT INTO CATALOGO ( id_catalogo,  nombre_parametros, valor_parametro) VALUES (?,?,?) ";

    private static final String SQL_UPDATE = "UPDATE CATALOGO SET nombre_parametros=?, valor_parametro=? WHERE id_catalogo=?";

    private static final String SQL_DELETE = "DELETE FROM CATALOGO WHERE id_catalogo=?";

    public List<DataCatalogo> listarCatalogo() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        DataCatalogo catalogo = null;
        List<DataCatalogo> catalogos = new ArrayList<>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();

            while (rs.next()) {

                int id_catalogo = rs.getInt("id_catalogo");
                String nombre_parametros = rs.getString("nombre_parametros");
                String valor_parametro = rs.getString("valor_parametro");

                catalogo = new DataCatalogo(id_catalogo, nombre_parametros, valor_parametro);
                catalogos.add(catalogo);

            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);

        }
        return catalogos;
    }

    public int insertar(DataCatalogo user) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, user.getId_catalogo());
            stmt.setString(2, user.getNombre_parametros());
            stmt.setString(3, user.getValor_parametro());

            rows = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {

            Conexion.close(stmt);
            Conexion.close(conn);

        }
        return rows;

    }

    public int Actualizar(DataCatalogo user) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, user.getNombre_parametros());
            stmt.setString(2, user.getValor_parametro());
            stmt.setInt(3, user.getId_catalogo());
            rows = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {

            Conexion.close(stmt);
            Conexion.close(conn);

        }
        return rows;

    }

    public int Eliminar(DataCatalogo user) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, user.getId_catalogo());
            rows = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {

            Conexion.close(stmt);
            Conexion.close(conn);

        }
        return rows;

    }
}
