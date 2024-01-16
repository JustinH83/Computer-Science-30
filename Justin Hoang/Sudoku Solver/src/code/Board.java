package code;

import java.io.File;
import java.util.Scanner;

public class Board {
	private Cell[][] board = new Cell[9][9];
	private Board[][]guesses = new Board[9][9];
	
	//The variable "level" records the level of the puzzle being solved.
	private String level = "";

	
	///TODO: CONSTRUCTOR
	//This must initialize every cell on the board with a generic cell.  It must also assign all of the boxIDs to the cells
	public Board()
	{
		for(int x = 0; x < 9; x++)
			for(int y = 0 ; y < 9; y++)
			{
				board[x][y] = new Cell();
				board[x][y].setBoxID( 3*(x/3) + (y)/3+1);
			}
		/*
		for(int x = 0; x < 9; x++)
			for(int y = 0 ; y < 9; y++)
				guesses[x][y] = new Cell[1];
				*/
	}
	

	
	///TODO: loadPuzzle
	/*This method will take a single String as a parameter.  The String must be either "easy", "medium" or "hard"
	 * If it is none of these, the method will set the String to "easy".  The method will set each of the 9x9 grid
	 * of cells by accessing either "easyPuzzle.txt", "mediumPuzzle.txt" or "hardPuzzle.txt" and setting the Cell.number to 
	 * the number given in the file.  
	 * 
	 * This must also set the "level" variable
	 * TIP: Remember that setting a cell's number affects the other cells on the board.
	 */
	public void loadPuzzle(String level) throws Exception
	{
		this.level = level;
		String fileName = "easyPuzzle.txt";
		if(level.contentEquals("medium"))
			fileName = "mediumPuzzle.txt";
		else if(level.contentEquals("hard"))
			fileName = "hardPuzzle.txt";
		
		Scanner input = new Scanner (new File(fileName));
		
		for(int x = 0; x < 9; x++)
			for(int y = 0 ; y < 9; y++)
			{
				int number = input.nextInt();
				if(number != 0)
					solve(x, y, number);
			}
						
		input.close();
		
	}
	
	///TODO: isSolved
	/*This method scans the board and returns TRUE if every cell has been solved.  Otherwise it returns FALSE
	 * 
	 */
	public boolean isSolved()
	{
		for(int x = 0; x<9;x++) 
			for(int y =0;y<9;y++) 
				if(board[x][y].numberOfPotentials() !=1)
					return false;
		return true;
	}
	
	public Cell cellAt(int x, int y) {
		return board[x][y];
	}


	///TODO: DISPLAY
	/*This method displays the board neatly to the screen.  It must have dividing lines to show where the box boundaries are
	 * as well as lines indicating the outer border of the puzzle
	 */
	public void display()
	{
		System.out.println("");
		for(int x = 0; x<9;x++) {
			if(x%3==0)
				for(int y = 0;y<22;y++) 
					System.out.print("-");
			System.out.println("");
			for(int y =0;y<9;y++) {
				if(y%3==0)
					System.out.print("|");
				System.out.print(board[x][y].getNumber() + " ");
			}
			System.out.println("|");
		}
		
	}
	
	///TODO: solve
	/*This method solves a single cell at x,y for number.  It also must adjust the potentials of the remaining cells in the same row,
	 * column, and box.
	 */
	public void solve(int x, int y, int number)
	{
		
		for(int z = 0;z<9;z++) 
			board[z][y].cantBe(number);
		for(int z = 0;z<9;z++) 
			board[x][z].cantBe(number);
		for(int a=0;a<9;a++) 
			for(int b=0;b<9;b++) 
				if(board[a][b].getBoxID() == board[x][y].getBoxID()) 
					board[a][b].cantBe(number);
		board[x][y].setNumber(number);
	}
	
	
	//logicCycles() continuously cycles through the different logic algorithms until no more changes are being made.
	public void logicCycles()throws Exception
	{
		Scanner input = new Scanner(System.in);
		int xcoord=0;
		int ycoord=0;
		int temp;
		
		while(isSolved() == false)
		{
			int changesMade = 0;
			do
			{
				changesMade = 0;
				changesMade += logic1();
				display();
				input.nextInt();
				changesMade += logic2();
				display();
				input.nextInt();
				changesMade += logic3();
				display();
				input.nextInt();
				
				changesMade += logic4();
				display();
				input.nextInt();
				
				if(errorFound()) {
					System.out.println("error");
					break;
				}
			}while(changesMade != 0);
			if(errorFound())
				break;
			while(!isSolved()) {
				for(int x=0;x<9;x++) 
					for(int y=0;y<9;y++) 
						if(guesses[x][y]==null) {
							xcoord=x;
							ycoord=y;
							x=9;
							break;
						}
				guesses[xcoord][ycoord] = new Board();
				for(int x =0;x<9;x++)
					for(int y=0;y<9;y++) {
						if(board[x][y].getNumber()!=0)
							guesses[xcoord][ycoord].solve(x,y,board[x][y].getNumber());
					}
				System.out.println("Current board stored at (" + xcoord + "," + ycoord + ")");
				for(int x=0;x<9;x++) 
					for(int y=0;y<9;y++) 
						if(board[x][y].getNumber()==0) {
							System.out.println("Guess made at (" + x + "," + y + "). Guess was " + board[x][y].getFirstPotential());
							solve(x,y,board[x][y].getFirstPotential());
							logicCycles();
							if(isSolved()) {
								x=9;
								break;
							}
							else {
								board = new Cell[9][9];
								for(int a = 0; a < 9; a++)
									for(int b = 0 ; b < 9; b++)
									{
										board[a][b] = new Cell();
										board[a][b].setBoxID( 3*(a/3) + (b)/3+1);
									}
								for(int a =0;a<9;a++)
									for(int b=0;b<9;b++) 
										if(guesses[xcoord][ycoord].cellAt(a, b).getNumber()!=0)
											solve(a,b,guesses[xcoord][ycoord].cellAt(a,b).getNumber());
								board[x][y].cantBe(board[x][y].getFirstPotential());
								System.out.println("Cell at (" + x + "," + y + ") cant be " + board[x][y].getFirstPotential());
								guesses[xcoord][ycoord]=null;
								x=9;
								break;
							}
						}
					
				
			}
	
		}			
		
	}
	
	
	///TODO: logic1
	/*This method searches each row of the puzzle and looks for cells that only have one potential.  If it finds a cell like this, it solves the cell 
	 * for that number. This also tracks the number of cells that it solved as it traversed the board and returns that number.
	 */
	public int logic1()
	{
		System.out.println("Logic 1: ");
		int changesMade = 0;
		for(int a=0;a<9;a++) 
			for(int b=0;b<9;b++) 
				if(board[a][b].numberOfPotentials()==1 && board[a][b].getNumber()==0) {
					solve(a,b,board[a][b].getFirstPotential());
					changesMade++;
				}
		return changesMade;
					
	}
	
	///TODO: logic2
	/*This method searches each row for a cell that is the only cell that has the potential to be a given number.  If it finds such a cell and it
	 * is not already solved, it solves the cell.  It then does the same thing for the columns.This also tracks the number of cells that 
	 * it solved as it traversed the board and returns that number.
	 */
	
	public int logic2()
	{
		System.out.println("Logic 2: ");
		int changesMade = 0;
		boolean contains;
		boolean change;
		int place;
		//rows
		for(int a=0;a<9;a++) 
			for(int n=1;n<10;n++) {
				place = 0;
				contains = false;
				change = false;
				for(int b=0;b<9;b++) {
					if(board[a][b].canBe(n) && contains == false) {
						contains = true;
						change = true;
						place = b;
					}
					else if(board[a][b].canBe(n)) {
						change = false;
						break;
					}
				}
				if(change == true && board[a][place].getNumber()==0) {
					solve(a,place,n);
					changesMade++;
				}
			}
		//columns
		for(int b=0;b<9;b++) 
			for(int n=1;n<10;n++) {
				place = 0;
				contains = false;
				change = false;
				for(int a=0;a<9;a++) {
					if(board[a][b].canBe(n) && contains == false) {
						contains = true;
						change = true;
						place = a;
					}
					else if(board[a][b].canBe(n)) {
						change = false;
						break;
					}
				}
				if(change == true && board[place][b].getNumber()==0) {
					solve(place,b,n);
					changesMade++;
				}
			}
		return changesMade;
	}
	
	///TODO: logic3
	/*This method searches each box for a cell that is the only cell that has the potential to be a given number.  If it finds such a cell and it
	 * is not already solved, it solves the cell. This also tracks the number of cells that it solved as it traversed the board and returns that number.
	 */
	public int logic3()
	{
		System.out.println("Logic 3: ");
		int changesMade = 0;
		boolean contains;
		boolean change;
		int height=0;
		int length=0;
		for(int a =0;a<3;a++) 
			for(int b = 0;b<3;b++)
				for(int n=1;n<10;n++) {
					height = 0;
					length = 0;
					contains = false;
					change = false;
					for(int c =0;c<3;c++)
						for(int d = 0;d<3;d++) {
							if(board[3*a + c][3*b + d].canBe(n) && contains == false) {
								contains = true;
								change = true;
								height = c;
								length = d;
							}
							else if(board[3*a + c][3*b + d].canBe(n)) {
								change = false;
								c=3;
								break;
							}
						}
					if(change == true && board[3*a + height][3*b + length].getNumber()==0) {
						solve(3*a + height,3*b + length,n);
						changesMade++;
					}
				}
		return changesMade;
	}
	
	
	///TODO: logic4
		/*This method searches each row for the following conditions:
		 * 1. There are two unsolved cells that only have two potential numbers that they can be
		 * 2. These two cells have the same two potentials (They can't be anything else)
		 * 
		 * Once this occurs, all of the other cells in the row cannot have these two potentials.  Write an algorithm to set these two potentials to be false
		 * for all other cells in the row.
		 * 
		 * Repeat this process for columns and rows.
		 * 
		 * This also tracks the number of cells that it solved as it traversed the board and returns that number.
		 */
	public int logic4()
	{
		System.out.println("Logic 4: ");
		int changesMade = 0;
		int temp;
		boolean multiple;
		//rows
		for(int a=0;a<9;a++) {
			temp=-1;
			do {
				multiple = false;
				for(int b=++temp;b<9;b++) {
					if(board[a][b].numberOfPotentials()==2 && multiple == false) {
						temp = b;
						multiple = true;
					}
					else if(board[a][b].numberOfPotentials()==2 && multiple == true  && board[a][temp].getFirstPotential() == board[a][b].getFirstPotential() && board[a][temp].getSecondPotential() == board[a][b].getSecondPotential()) { 
						for(int z = 0;z<9;z++) {
							if(board[a][z].getNumber()==0)
								if(board[a][z].numberOfPotentials()!=2 || board[a][z].getFirstPotential()!=board[a][b].getFirstPotential() || board[a][z].getSecondPotential()!=board[a][b].getSecondPotential()) {
									board[a][z].cantBe(board[a][b].getFirstPotential());
									board[a][z].cantBe(board[a][b].getSecondPotential());
									changesMade++;
							}
						}
					}
				}
			}while(temp<8);
		}
		//columns
		for(int b=0;b<9;b++) {
			temp=-1;
			do {
				multiple = false;
				for(int a=++temp;a<9;a++) {
					if(board[a][b].numberOfPotentials()==2 && multiple == false) {
						temp = a;
						multiple = true;
					}
					else if(board[a][b].numberOfPotentials()==2 && multiple == true && board[temp][b].getFirstPotential() == board[a][b].getFirstPotential() && board[temp][b].getSecondPotential() == board[a][b].getSecondPotential()) {
						for(int z = 0;z<9;z++) {
							if(board[z][b].getNumber()==0)
								if(board[z][b].numberOfPotentials()!=2 || board[z][b].getFirstPotential()!=board[a][b].getFirstPotential() || board[z][b].getSecondPotential()!=board[a][b].getSecondPotential()) {
									board[z][b].cantBe(board[a][b].getFirstPotential());
									board[z][b].cantBe(board[a][b].getSecondPotential());
									changesMade++;
								}
						}
					}
				}
			}while(temp<8);
		}
		return changesMade;
	}
	
	
	///TODO: errorFound
	/*This method scans the board to see if any logical errors have been made.  It can detect this by looking for a cell that no longer has the potential to be 
	 * any number.
	 */
	public boolean errorFound()
	{
		for(int a=0;a<9;a++)
			for(int b=0;b<9;b++)
				if(board[a][b].numberOfPotentials()==0)
					return true;
		return false;
	}
	
	
}
