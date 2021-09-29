package logica;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import persistencia.Conexion;

public class UsuariosDao {

    private static final String SQL_SELECT = "SELECT id_Usuario,  usuario, nombre, apellido, contraseña, correo_electronico,  rol, tipo_identificacion, catalogo FROM USUARIOS";

    private static final String SQL_INSERT = "INSERT INTO USUARIOS ( id_Usuario,  usuario, nombre, apellido, contraseña, correo_electronico,  rol, tipo_identificacion, catalogo ) VALUES (?,?,?,?,?,?,?,?,?) ";

    private static final String SQL_UPDATE = "UPDATE USUARIOS SET usuario=?, nombre=?, apellido=?, contraseña=?, correo_electronico=?,  rol=?, tipo_identificacion=?, catalogo=? WHERE id_Usuario=?";

    private static final String SQL_DELETE = "DELETE FROM USUARIOS WHERE id_Usuario=?";

    public List<DataUsuarios> listarUsuario() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        DataUsuarios user = null;
        List<DataUsuarios> usuarios = new ArrayList<>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();

            while (rs.next()) {

                int id_Usuario = rs.getInt("id_Usuario");
                String usuario = rs.getString("usuario");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String contraseña = rs.getString("contraseña");
                String correo_electronico = rs.getString("correo_electronico");
                int rol = rs.getInt("rol");
                int tipo_identificacion = rs.getInt("tipo_identificacion");
                int catalogo = rs.getInt("catalogo");

                user = new DataUsuarios(id_Usuario, usuario, nombre, apellido, contraseña, correo_electronico, rol, tipo_identificacion, catalogo);
                usuarios.add(user);

            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);

        }
        return usuarios;
    }

}
