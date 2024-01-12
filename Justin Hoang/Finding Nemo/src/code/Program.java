package code;

import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int width = input.nextInt();
		int height = input.nextInt();
		LinkedGrid board = new LinkedGrid(width, height);
		for(int x = 0; x<height; x++) {
			String temp =input.next();
			board.populate(temp, x);
		}
		if(board.flood())
			System.out.println("true");
		else
			System.out.println("false");
	}

}
