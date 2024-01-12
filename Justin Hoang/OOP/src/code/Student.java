package code;

public class Student {
	//ACCESS MODIFIERS: PUBLIC PRIVATE PROTECTED
	private int grade;
	private String firstName;
	private String lastName;
	private double gpa;
	
	
	//CONSTRUCTOR - sets up object
	/*
	 * must have same name as object
	 * no return type
	 */
	public Student() {
		grade = 1;
		firstName = "Justin";
		lastName = "Hoang";
		gpa = 4;
	}
	//overloading a constructor
	public Student(String firstName, String lastName) {
		grade = 1;
		this.firstName = firstName;
		this.lastName = lastName;
		gpa = 4;
	}
	
	
	
	//accessors and modifiers AFA GETTERS AND SETTERS
	
	//SETTERS
	public void setGrade(int grade) {
		this.grade = grade; 
	}
	//GETTERS
	public int getGrade() {
		return grade;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastname() {
		return lastName;
	}
	public void setLastname(String lastName) {
		this.lastName = lastName;
	}
	public double getGpa() {
		return gpa;
	}
	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
}
