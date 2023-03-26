package SpringDatabase.Dao.rowMapper;

import SpringDatabase.dto.Employee;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeRowMapper implements RowMapper {
    @Override
    public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
        Employee employee = new Employee();
        employee.setId(rs.getString(1));
        employee.setName(rs.getString(2));
        employee.setExp(rs.getInt(3));

        return employee;
    }
}
