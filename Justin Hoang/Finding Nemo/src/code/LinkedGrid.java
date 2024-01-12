package code;

public class LinkedGrid {
	Node start;
	boolean path = false;
	
	public LinkedGrid(int width, int height) {
		Node temp = null;
		start = new Node();
		Node columnMarker = start;
		Node rowMarker = start;
		
		for(int x = 0; x<width-1;x++){
			temp = new Node();
			columnMarker.setRight(temp);
			temp.setLeft(columnMarker);
			columnMarker = temp;
		}
		for(int y=0; y<height-1;y++) {
			temp = new Node();
			rowMarker.setDown(temp);
			temp.setUp(rowMarker);
			columnMarker = temp;
			
			for(int x=0;x<width-1;x++) {
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
	public void populate(String sequence, int row) {
		Node n = start;
		int count=0;
		for(int x = 0; x<row; x++) 
			n = n.getDown();
		while(n!=null) {
			if(sequence.charAt(count++)=='#') 
				n.setData(1);
			n=n.getRight();
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
	public boolean flood() {
		return(flood(start));
	}
	
	public boolean flood(Node n){
		if(n.getRight()==null && n.getDown()==null) {
			path = true;
			return path;
		}
		n.setData(1);
		try {
			if(n.getRight().getData() == 0)
				flood(n.getRight());
		}
		catch(Exception e) {}
		try {
			if(n.getDown().getData() == 0)
				flood(n.getDown());
		}
		catch(Exception e) {}
		try {
			if(n.getLeft().getData() == 0)
				flood(n.getLeft());
		}
		catch(Exception e) {}
		try {
			if(n.getUp().getData() == 0)
				flood(n.getUp());
		}
		catch(Exception e) {}
		return path;
	}
}
