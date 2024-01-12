package code;

public class Cell {
	private int number; // This is the solved value of the cell.
	private boolean[] potential = {false, true, true, true, true, true, true, true, true, true};
	/*This array represents the potential of the cell to be each of the given index numbers.  Index [0] is not used since
	 * the cell cannot be solved for 0. 
	 */
	private int boxID;//The boxID is the box to which the cell belongs.
	
	//USEFUL METHODS:
	
	///TODO: canBe 
	//This method returns TRUE or False depending on whether the cell has the potential to be number
	public boolean canBe(int number)
	{
		if(potential[number] == true)
			return true;
		return false;
	}
	
	///TODO: cantBe
	//This sets the potential array to be false for a given number
	public void cantBe(int number)
	{
		potential[number] = false;
	}
	
	///TODO: numberOfPotentials
	//This method returns a count of the number of potential numbers that the cell could be.
	public int numberOfPotentials()
	{
		int count = 0;
		for(int x=1;x<10;x++)
			if(potential[x] == true)
				count++;
		return count;
	}
	
	///TODO: getFirstPotential
	//This method will return the first number that a cell can possibly be.
	public int getFirstPotential()
	{
		for(int x=1;x<potential.length;x++)
			if(potential[x] == true)
				return x;
		return 0;
	}
	
	public int getSecondPotential()
	{
		for(int x=1;x<potential.length;x++)
			if(potential[x] == true)
				for(int y = x +1 ;y<potential.length;y++)
					if(potential[y] == true)
						return y;
		return 0;
	}
	
	
	
	//GETTERS AND SETTERS
	public int getNumber() {
		return number;
	}
	
	///TODO: setNumber
	// This method sets the number for the cell but also sets all of the potentials for the cell (except for the solved number)
	//		to be false
	public void setNumber(int number) {
		this.number = number;
		for(int x=1;x<10;x++)
			potential[x]=false;
		potential[number] = true;
	}
	
	
	
	public boolean[] getPotential() {
		return potential;
	}
	public void setPotential(boolean[] potential) {
		this.potential = potential;
	}
	public int getBoxID() {
		return boxID;
	}
	public void setBoxID(int boxID) {
		this.boxID = boxID;
	}

}
