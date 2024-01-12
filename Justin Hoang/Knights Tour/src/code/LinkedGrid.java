package code;

public class LinkedGrid {
	Node start;
	int solutions = 0;
	int dimension;
	
	public LinkedGrid(int dimension) {
		this.dimension = dimension;
		Node temp = null;
		start = new Node();
		Node columnMarker = start;
		Node rowMarker = start;
		
		for(int x = 0; x<dimension-1;x++){
			temp = new Node();
			columnMarker.setRight(temp);
			temp.setLeft(columnMarker);
			columnMarker = temp;
		}
		for(int y=0; y<dimension-1;y++) {
			temp = new Node();
			rowMarker.setDown(temp);
			temp.setUp(rowMarker);
			columnMarker = temp;
			
			for(int x=0;x<dimension-1;x++) {
				temp = new Node();
				columnMarker.setRight(temp);
				temp.setLeft(columnMarker);
				temp.setUp(columnMarker.getUp().getRight());
				temp.getUp().setDown(temp);
				columnMarker = temp;
			}
			rowMarker = rowMarker.getDown();
		}
	}
	
	public void display() {
		Node temp = start;
		Node rowMarker = start;
		while(temp!=null) {
			while(temp!=null) {
				System.out.print(temp.getData() + " ");
				temp=temp.getRight();
			}
			rowMarker = rowMarker.getDown();
			temp = rowMarker;
			System.out.println();
		}
			
	}
	public void freedom(Node n) {
		int freedom = 0;
		try {
			if(n.getUp().getUp().getLeft().getData() == 0) 
				freedom++;
		}
		catch(Exception e) {}
		try {
			if(n.getUp().getUp().getRight().getData() == 0) 
				freedom++;
		}
		catch(Exception e) {}
		try {
			if(n.getRight().getRight().getUp().getData() == 0) 
				freedom++;
		}
		catch(Exception e) {}
		try {
			if(n.getRight().getRight().getDown().getData() == 0) 
				freedom++;
		}
		catch(Exception e) {}
		try {
			if(n.getDown().getDown().getRight().getData() == 0) 
				freedom++;
		}
		catch(Exception e) {}
		try {
			if(n.getDown().getDown().getLeft().getData() == 0) 
				freedom++;
		}
		catch(Exception e) {}
		try {
			if(n.getLeft().getLeft().getDown().getData() == 0) 
				freedom++;
		}
		catch(Exception e) {}
		try {
			if(n.getLeft().getLeft().getUp().getData() == 0) 
				freedom++;
		}
		catch(Exception e) {}
		n.setDegreesOfFreedom(freedom);
	}
	
	public int tour() {
		//6x6: 524486
		start.setData(++Node.count);
		return(tour(start));
	}
	
	public int tour(Node n){
		//checks if there is a solution
		if(Node.count==(int)(Math.pow(dimension, 2))) {
			solutions++;
			display();
			System.out.println();
		}
		
		//set paths
		try {
			n.setPath1(n.getUp().getUp().getLeft());
		}
		catch(Exception e) {}
		try {
			n.setPath2(n.getUp().getUp().getRight());
		}
		catch(Exception e) {}
		try {
			n.setPath3(n.getRight().getRight().getUp());
		}
		catch(Exception e) {}
		try {
			n.setPath4(n.getRight().getRight().getDown());
		}
		catch(Exception e) {}
		try {
			n.setPath5(n.getDown().getDown().getRight());
		}
		catch(Exception e) {}
		try {
			n.setPath6(n.getDown().getDown().getLeft());
		}
		catch(Exception e) {}
		try {
			n.setPath7(n.getLeft().getLeft().getDown());
		}
		catch(Exception e) {}
		try {
			n.setPath8(n.getLeft().getLeft().getUp());
		}
		catch(Exception e) {}
		
		//degrees of freedom
		if(n.getPath1() != null && n.getPath1().getData() == 0) {
			freedom(n.getPath1());
			if(n.getPath1().getDegreesOfFreedom() == 0 && Node.count<(int)(Math.pow(dimension, 2))-1)
				return solutions;
		}
		if(n.getPath2() != null && n.getPath2().getData() == 0) {
			freedom(n.getPath2());
			if(n.getPath2().getDegreesOfFreedom() == 0 && Node.count<(int)(Math.pow(dimension, 2))-1)
				return solutions;
		}
		if(n.getPath3() != null && n.getPath3().getData() == 0) {
			freedom(n.getPath3());
			if(n.getPath3().getDegreesOfFreedom() == 0 && Node.count<(int)(Math.pow(dimension, 2))-1)
				return solutions;
		}
		if(n.getPath4() != null && n.getPath4().getData() == 0) {
			freedom(n.getPath4());
			if(n.getPath4().getDegreesOfFreedom() == 0 && Node.count<(int)(Math.pow(dimension, 2))-1)
				return solutions;
		}
		if(n.getPath5() != null && n.getPath5().getData() == 0) {
			freedom(n.getPath5());
			if(n.getPath5().getDegreesOfFreedom() == 0 && Node.count<(int)(Math.pow(dimension, 2))-1)
				return solutions;
		}
		if(n.getPath6() != null && n.getPath6().getData() == 0) {
			freedom(n.getPath6());
			if(n.getPath6().getDegreesOfFreedom() == 0 && Node.count<(int)(Math.pow(dimension, 2))-1)
				return solutions;
		}
		if(n.getPath7() != null && n.getPath7().getData() == 0) {
			freedom(n.getPath7());
			if(n.getPath7().getDegreesOfFreedom() == 0 && Node.count<(int)(Math.pow(dimension, 2))-1)
				return solutions;
		}
		if(n.getPath8() != null && n.getPath8().getData() == 0) {
			freedom(n.getPath8());
			if(n.getPath8().getDegreesOfFreedom() == 0 && Node.count<(int)(Math.pow(dimension, 2))-1)
				return solutions;
		}
		
		
		//recursion 
		try {
			if(n.getPath1().getData() == 0) {
				n.getPath1().setData(++Node.count);
				tour(n.getPath1());
				n.getPath1().setData(0);
				Node.count--;
			}
		}
		catch(Exception e) {}
		try {
			if(n.getPath2().getData() == 0) {
				n.getPath2().setData(++Node.count);
				tour(n.getPath2());
				n.getPath2().setData(0);
				Node.count--;
			}
		}
		catch(Exception e) {}
		try {
			if(n.getPath3().getData() == 0) {
				n.getPath3().setData(++Node.count);
				tour(n.getPath3());
				n.getPath3().setData(0);
				Node.count--;
			}
		}
		catch(Exception e) {}
		try {
			if(n.getPath4().getData() == 0) {
				n.getPath4().setData(++Node.count);
				tour(n.getPath4());
				n.getPath4().setData(0);
				Node.count--;
			}
		}
		catch(Exception e) {}
		try {
			if(n.getPath5().getData() == 0) {
				n.getPath5().setData(++Node.count);
				tour(n.getPath5());
				n.getPath5().setData(0);
				Node.count--;
			}
		}
		catch(Exception e) {}
		try {
			if(n.getPath6().getData() == 0) {
				n.getPath6().setData(++Node.count);
				tour(n.getPath6());
				n.getPath6().setData(0);
				Node.count--;
			}
		}
		catch(Exception e) {}
		try {
			if(n.getPath7().getData() == 0) {
				n.getPath7().setData(++Node.count);
				tour(n.getPath7());
				n.getPath7().setData(0);
				Node.count--;
			}
		}
		catch(Exception e) {}
		try {
			if(n.getPath8().getData() == 0) {
				n.getPath8().setData(++Node.count);
				tour(n.getPath8());
				n.getPath8().setData(0);
				Node.count--;
			}
		}
		catch(Exception e) {}
		
		return solutions;
	}
}
