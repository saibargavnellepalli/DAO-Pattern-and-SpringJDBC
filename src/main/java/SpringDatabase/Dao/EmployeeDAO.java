package SpringDatabase.Dao;

import SpringDatabase.dto.Employee;

import java.util.*;

public interface EmployeeDAO {
    public void addEmployee(Employee employee);
    public List<Employee> findAllEmployees();
    public Employee getEmployeeById(String id);


}
