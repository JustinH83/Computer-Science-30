package code;

public class Teacher {
	
	public int iQ;
	public String name;
	
	public Teacher() {
		name = "Joe";
		iQ = 100;
	}
	public Teacher(String name) {
		this.name = name;
		iQ = 100;
		if(name.equals("Chow"))
			iQ=140;
	}
	
	
}
