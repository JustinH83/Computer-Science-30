package code;

import java.util.Scanner;

public class Program {
	
	public static int flood(int x, int y, int[][] board) {
		int count = board[x][y];
		int up, mid, down;
		if(board[x+1][y+1]==-1)
			up = 100;
		else
			up = flood(x+1,y+1,board);
		if(board[x][y+1]==-1)
			 return count;
		mid = flood(x,y+1,board);
		if(board[x-1][y+1]==-1)
			down = 100;
		else
			down = flood(x-1,y+1,board);
		if(mid == up && mid == down) {
			count+=mid;
		}
		else if(mid<up && mid<down) {
			count += mid;
		}
		else if(up==down)
			count += up;
		else if(up<down) {
			count+=up;
		}
		else {
			count +=down;
		}
		return count;
		
	}
	
	
	public static int greed(int x, int[][]board) {
		int count = board[x][1];
		int up, mid, down;
		for(int y=1;y<21;y++) {
			if(board[x+1][y+1]==-1)
				up=100;
			else
				up = board[x+1][y+1];
			if(board[x][y+1]==-1)
				mid = 0;
			else
				mid = board[x][y+1];
			if(board[x-1][y+1]==-1)
				down=100;
			else
				down = board[x-1][y+1];
			if(mid==up && up == down)
				count+=mid;
			else if(mid==down && mid<up)
				count+=mid;
			else if(mid==up && mid<down)
				count+=mid;
			else if(mid<up && mid<down)
				count += mid;
			else if(up==down) {
				count+=up;
				x++;
			}
			else if(up<down) {
				count+=up;
				x++;
			}
			else {
				count +=down;
				x--;
			}
		}
		return count;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] board = new int[22][22];
		int number;
		int max=100;
		int greed =100;
		int greedTemp = 0;
		int temp;
		Scanner input = new Scanner(System.in);
		for(int x = 0; x<22;x++) {
			board[0][x] = -1;
		}
		for(int x = 1; x < 21; x++) {
			board[x][0] = -1;
			board[x][21] = -1;
			for(int y = 1; y<21;y++) {
				number = input.nextInt();
				board[x][y] = number;
			}
		}
		for(int x = 0; x<22;x++) {
			board[21][x] = -1;
		}
		
		for(int x = 1;x<21;x++) {
			temp = flood(x,1,board);
			greedTemp = greed(x,board);
			if(greed>greedTemp)
				greed = greedTemp;
			if(temp<max)
				max = temp;
		}
		System.out.println("Optimal: " + max);
		System.out.println("greed: " + greed);
	}

}
