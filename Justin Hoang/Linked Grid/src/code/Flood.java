package code;

import java.util.Scanner;

public class Flood {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedGrid board;
		int choice;
		String playAgain;
		Scanner input = new Scanner(System.in);
		int guesses;
		
		do {
			guesses = 0;
			board = new LinkedGrid(20);
			do {
				board.display();
				System.out.println("Choose a number: ");
				choice = input.nextInt();
				board.flood(choice);
				System.out.println(++guesses + "" + "/" + "35" );
			}while(board.filled() == false && guesses<35);
			if(board.filled() == true)
				System.out.println("you win!");
			else
				System.out.println("you lost");
			
			System.out.println("Do you want to play again? (y/n)");
			playAgain = input.next();
		}while(playAgain.equals("y"));
	}

}
