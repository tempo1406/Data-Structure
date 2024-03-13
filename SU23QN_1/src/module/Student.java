package module;

public class Student {

	public int id;
	public String fullName;
	public int yearOfBirth;
	public double avg;

	public Student(int id, String fullname, int year, double avg) {
		this.id = id;
		this.fullName = fullname;
		this.yearOfBirth = year;
		this.avg = avg;
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

	public double getAvg() {
		return avg;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", fullName=" + fullName + ", yearOfBirth=" + yearOfBirth + ", avg=" + avg + "]";
	}
	
	
}
