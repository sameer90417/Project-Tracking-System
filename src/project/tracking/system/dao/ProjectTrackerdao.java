/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project.tracking.system.dao;

import project.tracking.system.entity.ProjectTracker;

/**
 *
 * @author hp
 */
public interface ProjectTrackerdao {
    
    public boolean addTrackDetails(ProjectTracker tracker);
    
    public boolean updateTrackDetails(ProjectTracker tracker);
    
    public ProjectTracker getTrackingDetails(int pid);
  
}
