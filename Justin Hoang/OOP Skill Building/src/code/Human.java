package code;

public class Human {
	private String name;
	private int age;
	private boolean healthy;
	
	public Human() {
		age = 0;
		healthy = true;
	}
	public Human(String name) {
		this.name = name;
		age = 0;
		healthy = true;
	}
	public Human(int age, boolean healthy) {
		this.age = age;
		this.healthy = healthy;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		if(age>30 && Math.random()<=0.2)
			return age-5;
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isHealthy() {
		return healthy;
	}

	public void setHealthy(boolean healthy) {
		this.healthy = healthy;
	}
	
	public int add(int num1, int num2) {
		return num1+num2;
	}
	public int add(String word1, String word2) {
		int num1;
		int num2;
		if(word1.equals("one"))
			num1 = 1;
		else if(word1.equals("two"))
			num1=2;
		else if(word1.equals("three"))
			num1=3;
		else if(word1.equals("four"))
			num1=4;
		else if(word1.equals("five"))
			num1=5;
		else if(word1.equals("six"))
			num1=6;
		else if(word1.equals("seven"))
			num1=7;
		else if(word1.equals("eight"))
			num1=8;
		else if(word1.equals("nine"))
			num1=9;
		else if(word1.equals("ten"))
			num1=10;
		else {
			System.out.println("Error. Number not recognized");
			return -1;
		}
		
		if(word2.equals("one"))
			num2 = 1;
		else if(word2.equals("two"))
			num2=2;
		else if(word2.equals("three"))
			num2=3;
		else if(word2.equals("four"))
			num2=4;
		else if(word2.equals("five"))
			num2=5;
		else if(word2.equals("six"))
			num2=6;
		else if(word2.equals("seven"))
			num2=7;
		else if(word2.equals("eight"))
			num2=8;
		else if(word2.equals("nine"))
			num2=9;
		else if(word2.equals("ten"))
			num2=10;
		else {
			System.out.println("Error. Number not recognized");
			return -1;
		}
		
		return num1 + num2;
	}
	
	public void printVariables() {
		System.out.println("Age: " + age);
		System.out.println("Name: " + name);
		System.out.println("Healthy: " + healthy);
	}
	
	public void checkName(Human h) {
		System.out.println(h.getName());
	} 
}
