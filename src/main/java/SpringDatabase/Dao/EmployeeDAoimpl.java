package SpringDatabase.Dao;

import SpringDatabase.Dao.rowMapper.EmployeeRowMapper;
import SpringDatabase.dto.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeDAoimpl implements EmployeeDAO {
    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
@Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void addEmployee(Employee employee) {
       String sql = "insert into employee values('" +employee.getId()+ "','"  + employee.getName() +"',"+employee.getExp()+")";
       jdbcTemplate.update(sql);
    }

    @Override
    public List<Employee> findAllEmployees() {

       List<Employee> list = new ArrayList<>();
        EmployeeRowMapper employeeRowMapper = new EmployeeRowMapper();
       list = jdbcTemplate.query("select * from employee",employeeRowMapper);


       /*
        try {

            System.out.println("vachan ra findallemployee method lo ki");
            String driver = "com.mysql.cj.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/springjdbc";
            String username = "root";
            String password = "barGavSaI@7#";

            Class.forName(driver);
            Connection con = DriverManager.getConnection(url, username, password);
            Statement stmt = con.createStatement();
            ResultSet set = stmt.executeQuery("select * from employee");

            while (set.next()) {

                String id = set.getString(1);
                String name = set.getString(2);
                int exp = set.getInt(3);
                Employee employee = new Employee(id,name,exp);
                list.add(employee);
                System.out.println(name);

            }
            con.close();
        }
        catch (Exception e){

        }

        */

        return list;
    }

    @Override
    public Employee getEmployeeById(String id) {
        EmployeeRowMapper rowMapper = new EmployeeRowMapper();
       Employee employee = (Employee) jdbcTemplate.queryForObject("select * from employee where id = ?",rowMapper,id);


        return employee;
    }
}
