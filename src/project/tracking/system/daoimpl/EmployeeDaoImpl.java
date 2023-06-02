
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
    public boolean deleteEmployee(int eid) {
        int cid = -1;
        try {
            
            cid = getEmployeeCidByEid(eid);
            if(cid == -1) {
                return false;
            }
            else{
            con = ConnectionProvider.getConncection();
            Statement insert = con.createStatement();
            insert.addBatch("delete from pts_employee where eid = "+eid+";");
            insert.addBatch("delete from pts_credential where cid = "+cid+";");
            insert.executeBatch();
            
            return true;
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
    public boolean updateEmployee(Employee emp) {
        int cid = -1;
        boolean isUpdated=false;
        try {
            
            cid = getEmployeeCidByEid(emp.getEid());
            if(cid == -1) {
                return false;
            }
            else{
                emp.setCid(cid);
                 
                con = ConnectionProvider.getConncection();
                Statement insert = con.createStatement();
                insert.executeUpdate("Update pts_credential SET name='"+emp.getName()+"'"+", email='"+emp.getEmail()+"' WHERE cid="+emp.getCid());
                insert.executeUpdate("Update pts_employee SET emp_name='"+emp.getName()+"', profile='"+emp.getProfile()+"' WHERE eid="+emp.getEid());                
         
                return true;
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
    public Employee selectEmployee(int eid) {
        Employee emp = new Employee();
        try {
            
            con = ConnectionProvider.getConncection();
            Statement insert = con.createStatement();
            ResultSet set = insert.executeQuery("select * from pts_employee WHERE eid="+eid+";");
            set.next();
            emp.setEid(eid);
            emp.setCid(set.getInt("cid"));
            emp.setName(set.getString("emp_name"));
            emp.setProfile(set.getString("profile"));
            
            return emp;
            
        } catch (Exception e) {
             return null;
        } finally {
            try {
            con.close();
            } catch (Exception e) {}
        }
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
            
            String query = "INSERT INTO pts_employee(cid,emp_name,profile) values(?,?,?)";
            
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

    private int getEmployeeCidByEid(int eid) {
        try {
            con = ConnectionProvider.getConncection();
            
            String query = "SELECT cid FROM pts_employee where eid='"+eid+"';";
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
    public Employee getEmployeeByEmail(String email) {
        try {
            int cid = getEmployeeCidByEmail(email);
            con = ConnectionProvider.getConncection();
            
            String query = "SELECT * FROM pts_employee WHERE cid=?";
            
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setInt(1, cid);
            ResultSet set = pstmt.executeQuery();
            set.next();
            Employee emp = new Employee();
            emp.setCid(cid);
            emp.setEid(set.getInt("eid"));
            emp.setName(set.getString("emp_name"));
            emp.setEmail(email);
            emp.setProfile(set.getString("profile"));
            
            
            return emp;
        } catch (Exception e) {
            return null;
        } finally {
            try {
            con.close();
            } catch (Exception e) {}
        }
    }

    @Override
    public List<Integer> selectPidByEid(Employee emp) {
        try {
            con = ConnectionProvider.getConncection();
            
            String query = "SELECT pid FROM pts_"+emp.getProfile().toLowerCase()+" WHERE eid="+emp.getEid();
            
            Statement stmt = con.createStatement();
            ResultSet set = stmt.executeQuery(query);
            List<Integer> list = new ArrayList<Integer>();
            while (set.next()) {                
                list.add(set.getInt("pid"));
            }
            return list;
        } catch (Exception e) {
            return null;
        } finally {
            try {
            con.close();
            } catch (Exception e) {}
        }
    }
    
}
