
package project.tracking.system.database;

import java.sql.*;

public class Authenticator {
   public boolean Authenticate(String email, String password){
       
       boolean isExist = false; 
       Connection con;
       
       try {
           con = ConnectionProvider.getConncection();
           Statement stmt = con.createStatement();
           String query = "SELECT password FROM pts_credential WHERE email='"+email+"';";
           
           ResultSet set = stmt.executeQuery(query);
           
           if (set.next()) {
                String dbPassword = set.getString(1).trim();
                if (dbPassword.equals(password.trim()))
                    isExist = true;
            }
           
            
           return isExist;
           
           
       } catch (Exception e) {
           e.printStackTrace();
       } 
       return isExist;
   }
}
