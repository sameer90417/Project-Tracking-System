
package project.tracking.system.dao;

import java.util.List;
import project.tracking.system.entity.Employee;

public interface Employeedao {
    
    public boolean addEmployee(Employee emp);
    
    public boolean deleteEmployee(int eid);
    
    public boolean updateEmployee(Employee emp);
    
    public Employee selectEmployee(int eid);
    
    public List<Employee> selectAllEmployees();
    
    public int getEmployeeCidByEmail(String email);
    
    public Employee getEmployeeByEmail(String email);
    
    public boolean addEmployeeByCid(Employee emp);
    
    public List<Integer> selectPidByEid(Employee emp);
}
