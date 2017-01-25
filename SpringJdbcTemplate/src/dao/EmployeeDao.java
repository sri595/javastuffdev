package dao;

import org.springframework.jdbc.core.JdbcTemplate;

import springdo.Employee1;

public class EmployeeDao {

	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public int saveEmployee(Employee1 e) {

		String query = "insert into employee values('" + e.getId() + "','"
				+ e.getName() + "','" + e.getSalary() + "')";
		return jdbcTemplate.update(query);

	}

	public int updateEmployee(Employee1 e) {
		String query = "update employee set name='" + e.getName()
				+ "',salary='" + e.getSalary() + "' where id='" + e.getId()
				+ "' ";
		return jdbcTemplate.update(query);
	}

	public int deleteEmployee(Employee1 e) {
		String query = "delete from employee where id='" + e.getId() + "' ";
		return jdbcTemplate.update(query);
	}

}
