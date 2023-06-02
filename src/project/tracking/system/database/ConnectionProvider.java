
package project.tracking.system.database;
import java.sql.*;

public class ConnectionProvider {
    
    private static Connection con;
    private static final String url = "jdbc:mysql://localhost:3306/pts";
    private static final String username = "root";
    private static final String password = "Sam@1123";
    
    public static  Connection getConncection() throws SQLException, ClassNotFoundException{
        
        if (con == null) {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, username, password);
            return con;
        }
        
        return con;
        
    }
    
}
