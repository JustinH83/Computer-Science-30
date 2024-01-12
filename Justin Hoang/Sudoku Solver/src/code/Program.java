package code;

public class Program {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Board puzzle = new Board();
		puzzle.loadPuzzle("medium");
		puzzle.display();
		puzzle.logicCycles();
		puzzle.display();
		System.out.println(puzzle.errorFound());
		System.out.println(puzzle.isSolved());
	}

}
