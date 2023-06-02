/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project.tracking.system.dao;

import project.tracking.system.entity.Designer;


public interface Designerdao {
    
    public boolean allocateDesigner(Designer designer);
    
    public boolean deallocateDesigner(int did);
    
}
