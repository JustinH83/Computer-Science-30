package code;

public class Program {
	public static int birthday(Human h) {
		h.setAge(h.getAge()+1);
		System.out.println(h.getAge());
		return h.getAge();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Human bruno = new Human("bruno");
		Human justin = new Human("justin");
		justin.setAge(35);
		
		System.out.println( bruno.add (4,5) );
		System.out.println( bruno.add ("four","five") );
		
		justin.printVariables();
		System.out.println();
		bruno.printVariables();
		
		System.out.println(birthday(justin));
	}

}
