package SpringDatabase.Business;

import SpringDatabase.Dao.EmployeeDAO;
import SpringDatabase.Dao.EmployeeDAoimpl;
import SpringDatabase.dto.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.logging.SocketHandler;
@Component
public class EmployeeBusinessImpl implements EmployeeBusiness{

    @Autowired
    private EmployeeDAO employeeDAO;

    public EmployeeDAO getEmployeeDAO() {
        return employeeDAO;
    }

    public void setEmployeeDAO(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public void showHikes() {
        System.out.println("chinodu showhikes lo");
        // code to get employees
         List<Employee> employeesData = employeeDAO.findAllEmployees();
        System.out.println("pedodu showhikes lo size print chestunna chudu ra bamardi "+ employeesData.size());

        // to show the hikes from the data we got
       for (Employee cur : employeesData){
            if (cur.getExp() >= 3){
                System.out.println(cur.getName() + " got hike of 15% ");
            }
            else{
                System.out.println(cur.getName() +" got hike of 10%");
            }

        }
    }

    @Override
    public void insertEmployee(Employee employee) {
        employeeDAO.addEmployee(employee);

    }

    @Override
    public Employee getEmployeeById(String id) {
        return employeeDAO.getEmployeeById(id);

    }
}
