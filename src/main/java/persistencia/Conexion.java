package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;
import javax.swing.JOptionPane;
import org.apache.commons.dbcp2.BasicDataSource;

public class Conexion {
    private static final String JDBC_URL="jdbc:mysql://localhost:3306/icos?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String JDBC_USER="root";
    private static final String JDBC_PASSWORd="Futbol8.01";//cambiar password
    
  public  static DataSource  getDataSource(){
      
      BasicDataSource ds =new BasicDataSource();
      ds.setUrl(JDBC_URL);
      ds.setUsername(JDBC_USER);
      ds.setPassword(JDBC_PASSWORd);
      ds.setInitialSize(50);
      return ds;
    
  }  
    public static Connection getConnection() throws SQLException{
        return getDataSource().getConnection();
    
    
    }
    
    public static void close(ResultSet rs){
        try {
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
    public static void close(PreparedStatement  stmt){
        try {
            stmt.close();
        } catch (SQLException ex) {
            
            ex.printStackTrace(System.out);
        }
    }
    public static void close(Connection conn){
        try {
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
    
    public static void main(String[] args) throws SQLException {
        Conexion mysql = new Conexion();
        mysql.getConnection();
        System.out.println("conexion exitosa");
        JOptionPane.showMessageDialog(null, "Conexión exitosa");
        
    }
    
}
