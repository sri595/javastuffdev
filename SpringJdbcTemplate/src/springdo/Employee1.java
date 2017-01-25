package springdo;

public class Employee1 {

	private int id;
	private String name;
	private int salary;

	
	public Employee1() {
		// TODO Auto-generated constructor stub
	}
	public Employee1(int id, String name, int salary) {

		this.id = id;
		this.name = name;
		this.salary = salary;
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

}
