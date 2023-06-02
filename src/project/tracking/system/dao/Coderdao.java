/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project.tracking.system.dao;

import project.tracking.system.entity.Coder;
import java.sql.ResultSet;


public interface Coderdao {
    
    public boolean allocateCoder(Coder coder);
    
    public boolean deallocateCoder(int cdid);
    
    public ResultSet selectAllCoders(int pid);
    
}
