
public class Employee {
	public int id;
	public String fullName;
	public int yearOfBirth;
	public int salary;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(int id, String fullName, int yearOfBirth, int salary) {
		this.id = id;
		this.fullName = fullName;
		this.yearOfBirth = yearOfBirth;
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public int getYearOfBirth() {
		return yearOfBirth;
	}

	public void setYearOfBirth(int yearOfBirth) {
		this.yearOfBirth = yearOfBirth;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", fullName=" + fullName + ", yearOfBirth=" + yearOfBirth + ", salary=" + salary
				+ "]";
	}
	
	
}
