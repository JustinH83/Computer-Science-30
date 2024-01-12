package code;

public class Flood {
	static int count = 0;
	int store;
	public void flood(char[][] array, String word, int index, int verticle, int horizontal, int x, int y, boolean bend) {
		if(array[x][y] != word.charAt(index))
			return;
		if(index++ == word.length()-1) {
			count++;
			return;
		}
		flood(array, word, index, verticle, horizontal, x+verticle, y+horizontal, bend);
		if(bend == false && index>1) {
			if(verticle == 0) {
				flood(array, word, index, 1, 0, x+1, y, true);
				flood(array, word, index, -1, 0, x-1, y, true);
			}
			else if(horizontal == 0) {
				flood(array, word, index, 0, 1, x, y+1, true);
				flood(array, word, index, 0, -1, x, y-1, true);
			}
			else {
				flood(array, word, index, verticle, horizontal*-1, x+verticle, y-horizontal, true);
				flood(array, word, index, verticle*-1, horizontal, x-verticle, y+horizontal, true);
			}
		}
		index--;
	}
}
