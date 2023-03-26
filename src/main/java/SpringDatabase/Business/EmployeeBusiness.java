package SpringDatabase.Business;

import SpringDatabase.dto.Employee;

public interface EmployeeBusiness {
    public void showHikes();
    public void insertEmployee(Employee employee);
    public Employee getEmployeeById(String id);
}
