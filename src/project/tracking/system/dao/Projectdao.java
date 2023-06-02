
package project.tracking.system.dao;

import java.util.List;
import project.tracking.system.entity.Project;

public interface Projectdao {
    
    public boolean addProject(Project project);
    
    public boolean deleteProject(int pid);
    
    public boolean updateProject(Project project);
    
    public Project selectProject(int pid);
    
    public List<Project> selectAllProjects();
    
}
