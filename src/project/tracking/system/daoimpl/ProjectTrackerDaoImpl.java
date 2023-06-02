/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project.tracking.system.daoimpl;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import project.tracking.system.dao.ProjectTrackerdao;
import project.tracking.system.database.ConnectionProvider;
import project.tracking.system.entity.ProjectTracker;


public class ProjectTrackerDaoImpl implements ProjectTrackerdao{
        
    private Connection con;

    @Override
    public boolean addTrackDetails(ProjectTracker tracker) {
        try {
            con = ConnectionProvider.getConncection();
            Statement insert = con.createStatement();
            String query = "insert into pts_project_tracker(pid, Designers_task, Coders_task, Testers_task, completed_designers_task, completed_coders_task, completed_testers_task) "
                            + "values("+tracker.getPid()+","+tracker.getDesignersTask()+","+tracker.getCoderesTask()
                            +","+tracker.getTestersTask()+","+tracker.getCompletedDesignersTask()
                            +","+tracker.getCompletedCodersTask()+","+tracker.getCompletedTestersTask()+")";
            insert.executeUpdate(query);
            
            
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
    public boolean updateTrackDetails(ProjectTracker tracker) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ProjectTracker getTrackingDetails(int pid) {
        
        try {
            con = ConnectionProvider.getConncection();
            Statement insert = con.createStatement();
            String query = "select Designers_task, Coders_task, Testers_task, completed_designers_task, completed_coders_task, completed_testers_task from pts_project_tracker where pid="+pid;
            ResultSet set = insert.executeQuery(query);
           
            set.next();
            
            
            ProjectTracker tracker = new ProjectTracker();
            tracker.setPid(pid);
            tracker.setDesignersTask(set.getInt(1));
            tracker.setCoderesTask(set.getInt(2));
            tracker.setTestersTask(set.getInt(3));
            tracker.setCompletedDesignersTask(set.getInt(4));
            tracker.setCompletedCodersTask(set.getInt(5));
            tracker.setCompletedTestersTask(set.getInt(6));
            
            
            
            return tracker;
            
        } catch (Exception e) {
             return null;
        } finally {
            try {
            con.close();
            } catch (Exception e) {}
        }
        
    }
    
}
