package SpringDatabase;

import SpringDatabase.Business.EmployeeBusiness;
import SpringDatabase.Business.EmployeeBusinessImpl;
import SpringDatabase.dto.Employee;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App
{
    public static void main(String[] args) {
        ApplicationContext jdbc = new ClassPathXmlApplicationContext("config.xml");

        EmployeeBusiness employeeBusiness = (EmployeeBusinessImpl)jdbc.getBean("employeeBusinessImpl");
        //employeeBusiness.showHikes();

        /*Employee employee = new Employee("10","Charan",10);
        employeeBusiness.insertEmployee(employee);
         */

        Employee employee = employeeBusiness.getEmployeeById("2");
        System.out.println(employee.getName()+" "+employee.getExp());

    }
}
