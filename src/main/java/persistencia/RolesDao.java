package persistencia;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import logica.DataRoles;

public class RolesDao {

    private static final String SQL_SELECT = "SELECT id_rol, nombre_rol FROM ROLES";

    private static final String SQL_INSERT = "INSERT INTO ROLES ( id_rol, nombre_rol ) VALUES (?,?) ";

    private static final String SQL_UPDATE = "UPDATE ROLES SET nombre_rol=? WHERE id_rol=?";

    private static final String SQL_DELETE = "DELETE FROM ROLES WHERE id_rol=?";

    public List<DataRoles> listarRoles() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        DataRoles rol = null;
        List<DataRoles> roles = new ArrayList<>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();

            while (rs.next()) {

                int id_rol = rs.getInt("id_rol");
                String nombre_rol = rs.getString("nombre_rol");

                rol = new DataRoles(id_rol, nombre_rol);
                roles.add(rol);

            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);

        }
        return roles;
    }

    public int insertar(DataRoles user) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, user.getId_rol());
            stmt.setString(2, user.getNombre_rol());

            rows = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {

            Conexion.close(stmt);
            Conexion.close(conn);

        }
        return rows;

    }

    public int Actualizar(DataRoles user) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, user.getNombre_rol());
            stmt.setInt(2, user.getId_rol());
            rows = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {

            Conexion.close(stmt);
            Conexion.close(conn);

        }
        return rows;

    }

    public int Eliminar(DataRoles user) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, user.getId_rol());
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
