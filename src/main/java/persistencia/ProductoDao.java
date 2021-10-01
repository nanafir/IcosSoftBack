/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import logica.DataUsuarios;

/**
 *
 * @author nanaf
 */
public class ProductoDao {
     
    private static final String SQL_SELECT = "SELECT id_Usuario,  usuario, nombre, apellido, contraseña, correo_electronico,  rol, tipo_identificacion, catalogo FROM USUARIOS";

    private static final String SQL_INSERT = "INSERT INTO +tabla+ ( id_Usuario,  usuario, nombre, apellido, contraseña, correo_electronico,  rol, tipo_identificacion, catalogo ) VALUES (?,?,?,?,?,?,?,?,?) ";

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

    public int insertar(DataUsuarios user) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, user.getId_Usuario());
            stmt.setString(2, user.getUsuario());
            stmt.setString(3, user.getNombre());
            stmt.setString(4, user.getApellido());
            stmt.setString(5, user.getContraseña());
            stmt.setString(6, user.getCorreo_electronico());
            stmt.setInt(7, user.getRol());
            stmt.setInt(8, user.getTipo_identificacion());
            stmt.setInt(9, user.getCatalogo());

            rows = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {

            Conexion.close(stmt);
            Conexion.close(conn);

        }
        return rows;

    }

    public int Actualizar(DataUsuarios user) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, user.getUsuario());
            stmt.setString(2, user.getNombre());
            stmt.setString(3, user.getApellido());
            stmt.setString(4, user.getContraseña());
            stmt.setString(5, user.getCorreo_electronico());
            stmt.setInt(6, user.getRol());
            stmt.setInt(7, user.getTipo_identificacion());
            stmt.setInt(8, user.getCatalogo());
            stmt.setInt(9, user.getId_Usuario());
            rows = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {

            Conexion.close(stmt);
            Conexion.close(conn);

        }
        return rows;

    }

    public int Eliminar(DataUsuarios user) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, user.getId_Usuario());
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
