/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project.tracking.system.daoimpl;

import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.Statement;
import project.tracking.system.dao.Testerdao;
import project.tracking.system.database.ConnectionProvider;
import project.tracking.system.entity.Tester;


public class TesterDaoImpl implements Testerdao{
    
    private Connection con;

    @Override
    public boolean allocateTester(Tester tester) {
        try {
            
            con = ConnectionProvider.getConncection();
            Statement insert = con.createStatement();
            insert.executeUpdate("insert into pts_tester(eid,pid) values("+tester.getEid()+","+tester.getPid()+")");
            
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
    public boolean deallocateTester(int did) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
