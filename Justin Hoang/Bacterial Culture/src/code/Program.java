package code;

import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int dimensions = 100;
		LinkedGrid board = new LinkedGrid(dimensions);
		int a,b,c;
		Scanner input = new Scanner(System.in);
		String temp;
		for(int x =0; x<dimensions;x++) {
			temp = input.next();
			board.populate(temp, x);
		}
		
		a = board.flood(1);
		b = board.flood(2);
		c = board.flood(3);
		if(a>b && a>c) 
			System.out.println("A: " + a);
		else if(b>c && b>a)
			System.out.println("B " + b);
		else if(c>a && c>b)
			System.out.println("C " + c);
		else if(c==a && c>b)
			System.out.println("A and C " + c);
		else if(c==b && c>a)
			System.out.println("B and C " + c);
		else if(a==b && a>c)
			System.out.println("A and B " + a);
		System.out.println("A: " + a + " B: " + b + " C: " + c);
	}

}
