package code;

import java.util.Scanner;

public class Program {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		Flood board = new Flood();
		String word = input.next();
		int height = input.nextInt();
		int width = input.nextInt();
		char array[][] = new char[height+2][width+2];
		for(int x = 0; x<width+2;x++) 
			array[0][x] = '~';
		for(int x = 1; x<height+1;x++) {
			array[x] = ("~" + input.next() + "~").toCharArray();
		}
		for(int x = 0; x<width+2;x++) 
			array[height+1][x] = '~';
		
		for(int x = 1; x< height+1;x++) {
			for(int y =1; y<width+1;y++) {
				board.flood(array, word, 0, 0, 1, x, y, false);
				board.flood(array, word, 0, 0, -1, x, y, false);
				board.flood(array, word, 0, 1, 0, x, y, false);
				board.flood(array, word, 0, -1, 0, x, y, false);
				board.flood(array, word, 0, 1, 1, x, y, false);
				board.flood(array, word, 0, 1, -1, x, y, false);
				board.flood(array, word, 0, -1, 1, x, y, false);
				board.flood(array, word, 0, -1, -1, x, y, false);
			}
		}
		System.out.println(Flood.count);
		
	}

}
