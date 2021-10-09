package persistencia;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import logica.DataProducto;

public class ProductoDao {

    private static final String SQL_SELECT = "SELECT id_producto, nombre_producto, valor_venta, stock, fecha_expiracion FROM PRODUCTO";

    private static final String SQL_INSERT = "INSERT INTO PRODUCTO ( id_producto, nombre_producto, valor_venta, stock, fecha_expiracion ) VALUES (?,?,?,?,?) ";

    private static final String SQL_UPDATE = "UPDATE PRODUCTO SET nombre_producto=?, valor_venta=?, stock=?, fecha_expiracion=? WHERE id_producto=?";

    private static final String SQL_DELETE = "DELETE FROM PRODUCTO WHERE id_producto=?";

    public List<DataProducto> listarProduct() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        DataProducto userProducto = null;
        List<DataProducto> Productos = new ArrayList<>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();

            while (rs.next()) {

                int id_producto = rs.getInt("id_producto");
                String nombre_producto = rs.getString("nombre_producto");
                String valor_venta = rs.getString("valor_venta");
                String stock = rs.getString("stock");
                String fecha_expiracion = rs.getString("fecha_expiracion");

                userProducto = new DataProducto(id_producto, nombre_producto, Double.MAX_VALUE, id_producto, Date.valueOf(LocalDate.MAX));
                Productos.add(userProducto);

            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);

        }
        return Productos;
    }

    public int insertar(DataProducto user) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setInt(1, user.getId_producto());
            stmt.setString(2, user.getNombre_producto());
            stmt.setDouble(3, user.getValor_venta());
            stmt.setInt(4, user.getStock());
            stmt.setDate(5, (Date) user.getFecha_expiracion());

            rows = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {

            Conexion.close(stmt);
            Conexion.close(conn);

        }
        return rows;

    }

    public int Actualizar(DataProducto user) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, user.getNombre_producto());
            stmt.setDouble(2, user.getValor_venta());
            stmt.setInt(3, user.getStock());
            stmt.setDate(4, (Date) user.getFecha_expiracion());
            stmt.setInt(5, user.getId_producto());

            rows = stmt.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {

            Conexion.close(stmt);
            Conexion.close(conn);

        }
        return rows;

    }

    public int Eliminar(DataProducto user) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, user.getId_producto());
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
