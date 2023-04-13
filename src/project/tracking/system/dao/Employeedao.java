
package project.tracking.system.dao;

import java.util.List;
import project.tracking.system.entity.Employee;

public interface Employeedao {
    
    public boolean addEmployee(Employee emp);
    
    public boolean deleteEmployee();
    
    public boolean updateEmployee();
    
    public Employee selectEmployee();
    
    public List<Employee> selectAllEmployees();
    
    public int getEmployeeCidByEmail(String email);
    
    public boolean addEmployeeByCid(Employee emp);
}
