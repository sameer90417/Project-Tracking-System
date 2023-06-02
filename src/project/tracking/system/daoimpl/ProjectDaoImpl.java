
package project.tracking.system.daoimpl;

import java.sql.*;
import java.util.List;
import project.tracking.system.dao.Projectdao;
import project.tracking.system.database.ConnectionProvider;
import project.tracking.system.entity.Project;


public class ProjectDaoImpl implements Projectdao {
    
    private Connection con;

    @Override
    public boolean addProject(Project project) {
        try {
            con = ConnectionProvider.getConncection();
            
            String query = "INSERT INTO pts_project(pname,pdescription,designer,coder,tester,assigndate,enddate) values(?,?,?,?,?,?,?)";
            
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, project.getName());
            pstmt.setString(2,project.getDescription());
            pstmt.setInt(3, project.getNumberOfDesigner());
            pstmt.setInt(4, project.getNumberOfCoder());
            pstmt.setInt(5, project.getNumberOfTester());
            pstmt.setString(6, project.getAssignDate());
            pstmt.setString(7, project.getEndDate());
            
            pstmt.executeUpdate();
            return true;
            
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
            con.close();
            } catch (Exception e) {}
        }
    }

    @Override
    public boolean deleteProject(int pid) {
        try {
            
            con = ConnectionProvider.getConncection();
            Statement insert = con.createStatement();
            insert.executeUpdate("delete from pts_project where pid = "+pid+";");
            
            return true;
            
        } catch (Exception e) {
             return false;
        } finally {
            try {
            con.close();
            } catch (Exception e) {}
        }
    }

    @Override
    public boolean updateProject(Project project) {
        try {
            con = ConnectionProvider.getConncection();
            
            String query = "UPDATE pts_project set pname=?,pdescription=?,designer=?,coder=?,tester=?,assigndate=?,enddate=? WHERE pid = ?";
            
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, project.getName());
            pstmt.setString(2,project.getDescription());
            pstmt.setInt(3, project.getNumberOfDesigner());
            pstmt.setInt(4, project.getNumberOfCoder());
            pstmt.setInt(5, project.getNumberOfTester());
            pstmt.setString(6, project.getAssignDate());
            pstmt.setString(7, project.getEndDate());
            pstmt.setInt(8, project.getPid());
            
            pstmt.executeUpdate();
            return true;
            
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            try {
            con.close();
            } catch (Exception e) {}
        }
    }

    @Override
    public Project selectProject(int pid) {
        try {
            
            con = ConnectionProvider.getConncection();
            Statement insert = con.createStatement();
            ResultSet set = insert.executeQuery("select * from pts_project where pid = "+pid);
            
            Project project = new Project();
            
            set.next();
            
            project.setPid(pid);
            project.setName(set.getString("pname"));
            project.setDescription(set.getString("pdescription"));
            project.setNumberOfDesigner(set.getInt("designer"));
            project.setNumberOfCoder(set.getInt("coder"));
            project.setNumberOfTester(set.getInt("tester"));
            project.setAssignDate(set.getString("assigndate"));
            project.setEndDate(set.getString("enddate"));
            
            
            return project;
            
        } catch (Exception e) {
             return null;
        } finally {
            try {
            con.close();
            } catch (Exception e) {}
        }
    }

    @Override
    public List<Project> selectAllProjects() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
