package com.example.JDBCEMPLOYEE;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeejdbcImplementation {

    private final JdbcTemplate jdbcTemplate;


    public EmployeejdbcImplementation(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Employee queryEmployeeById(Integer id) {

        Employee emp = jdbcTemplate.queryForObject("select * from employee_entity where id=?", (resultSet, i) -> {
            Employee employee = new Employee();
            employee.setId(resultSet.getInt("id"));
            employee.setFirstName(resultSet.getString("first_name"));
            employee.setLastName(resultSet.getString("last_name"));
            return employee;
        }, id);
        System.out.println(emp);
        return emp;
    }

    public List<Employee> queryFromDatabase(int idLessThan) {

        return jdbcTemplate.query("select id,first_name,last_name from employee_entity where id<? ", preparedStatement -> preparedStatement.setInt(1, idLessThan), (resultSet, i) -> {
            Employee employee = new Employee();
            employee.setId(resultSet.getInt("id"));
            employee.setFirstName(resultSet.getString("first_name"));
            employee.setLastName(resultSet.getString("last_name"));
            return employee;
        });


    }


    public int delete(int id) {
        return jdbcTemplate.update("DELETE FROM employee_entity WHERE id=?", id);
    }

    public int save(Employee e) {
        return jdbcTemplate.update("INSERT INTO employee_entity (id, first_name,last_name) VALUES (?, ?, ?)", new Object[] {e.getId(), e.getFirstName(), e.getLastName()});
    }


}
