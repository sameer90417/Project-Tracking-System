
package project.tracking.system.daoimpl;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import project.tracking.system.dao.Employeedao;
import project.tracking.system.database.ConnectionProvider;
import project.tracking.system.entity.Employee;


public class EmployeeDaoImpl implements Employeedao {

    private Connection con;
    
    @Override
    public boolean addEmployee(Employee emp)  {
        try {
            con = ConnectionProvider.getConncection();
            
            String query = "INSERT INTO pts_credential(name,email,password) values(?,?,?)";
            
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, emp.getName());
            pstmt.setString(2,emp.getEmail());
            pstmt.setString(3, emp.getPassword());
            pstmt.executeUpdate();
            
            // extract cid from pts_credential and insert into pts_employee
            int cid = getEmployeeCidByEmail(emp.getEmail());
            System.out.println(cid);
            if(cid == -1) return false;
            else {
                emp.setCid(cid);
                boolean done = addEmployeeByCid(emp);
                if(done) return true;
                else return false;
            }
        } catch (Exception e) {
            return false;
        } finally {
            try {
            con.close();
            } catch (Exception e) {}
        }
    }

    @Override
    public boolean deleteEmployee() {
       return true;
    }

    @Override
    public boolean updateEmployee() {
        return true;
    }

    @Override
    public Employee selectEmployee() {
        Employee emp = new Employee();
        return emp;
    }

    @Override
    public List<Employee> selectAllEmployees() {
        List<Employee> list = new ArrayList<Employee>();
        return list;
    }

    @Override
    public int getEmployeeCidByEmail(String email) {
        try {
            con = ConnectionProvider.getConncection();
            
            String query = "SELECT cid FROM pts_credential where email='"+email+"';";
            Statement stmt = con.createStatement();
            ResultSet set = stmt.executeQuery(query);
            
            if(set.next()) {
                int cid = set.getInt(1);
                return cid;
            } else return -1;
            
        } catch (Exception e) {
            return -1;
        } finally {
            try {
            con.close();
            } catch (Exception e) {}
        }
    }

    @Override
    public boolean addEmployeeByCid(Employee emp) {
        try {
            con = ConnectionProvider.getConncection();
            
            String query = "INSERT INTO pts_employee(cid,name,profile) values(?,?,?)";
            
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setInt(1, emp.getCid());
            pstmt.setString(2,emp.getName());
            pstmt.setString(3, emp.getProfile());
            pstmt.executeUpdate();
            
            
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            try {
            con.close();
            } catch (Exception e) {}
        }
    }
    
}
