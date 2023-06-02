/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project.tracking.system.daoimpl;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.Statement;
import project.tracking.system.dao.Designerdao;
import project.tracking.system.database.ConnectionProvider;
import project.tracking.system.entity.Designer;


public class DesignerDaoImpl implements Designerdao{
    
    private Connection con;

    @Override
    public boolean allocateDesigner(Designer designer) {
        try {
            
            con = ConnectionProvider.getConncection();
            Statement insert = con.createStatement();
            insert.executeUpdate("insert into pts_designer(eid,pid) values("+designer.getEid()+","+designer.getPid()+")");
            
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
    public boolean deallocateDesigner(int did) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
