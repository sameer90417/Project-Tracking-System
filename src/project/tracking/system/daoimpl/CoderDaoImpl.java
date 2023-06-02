/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project.tracking.system.daoimpl;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import project.tracking.system.dao.Coderdao;
import project.tracking.system.database.ConnectionProvider;
import project.tracking.system.entity.Coder;


public class CoderDaoImpl implements Coderdao{
    
    private Connection con;

    @Override
    public boolean allocateCoder(Coder coder) {
        try {
            
            con = ConnectionProvider.getConncection();
            Statement insert = con.createStatement();
            insert.executeUpdate("insert into pts_coder(eid,pid) values("+coder.getEid()+","+coder.getPid()+")");
            
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
    public boolean deallocateCoder(int cdid) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ResultSet selectAllCoders(int pid) {
        try {
            
            con = ConnectionProvider.getConncection();
            Statement insert = con.createStatement();
            ResultSet set = insert.executeQuery("select pts_coder.eid, emp_name from pts_coder Inner Join pts_employee on pts_coder.eid=pts_employee.eid where pts_coder.pid=\"+project.getPid()");
            
            return set;
            
        } catch (Exception e) {
             return null;
        } finally {
            try {
            con.close();
            } catch (Exception e) {}
        }
    }
    
}
