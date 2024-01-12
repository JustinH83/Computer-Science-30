package code;

public class LinkedGrid {
	Node start;
	int count;
	
	public LinkedGrid(int dimension) {
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
	
	public void populate(String sequence, int row) {
		Node n = start;
		int count = 0;
		for(int x = 0; x<row; x++) 
			n = n.getDown();
		while(n!=null) {
			if(sequence.charAt(count)=='A') 
				n.setData(1);
			else if(sequence.charAt(count)=='B')
				n.setData(2);
			else if(sequence.charAt(count)=='C')
				n.setData(3);
			count++;
			n=n.getRight();
		}
	}
	
	public int flood(int bacteria) {
		Node temp = start;
		Node rowMarker = start;
		int largest = 0;
		int value;
		while(temp!=null) {
			while(temp!=null) {
				if(temp.isFlooded() == false && temp.getData() == bacteria) {
					count = 0;
					value = flood(temp, bacteria);
					if(value>largest)
						largest = value;
				}
				temp=temp.getRight();
			}
			rowMarker = rowMarker.getDown();
			temp = rowMarker;
		}
		return(largest);
	}
	
	public int flood(Node n, int bacteria){
		count++;
		n.setFlooded(true);
		try {
			if(n.getRight().getData() == bacteria && n.getRight().isFlooded() == false) {
				flood(n.getRight(), bacteria);
			}
		}
		catch(Exception e) {}
		try {
			if(n.getDown().getData() == bacteria && n.getDown().isFlooded() == false) {
				flood(n.getDown(), bacteria);
			}
		}
		catch(Exception e) {}
		try {
			if(n.getLeft().getData() == bacteria && n.getLeft().isFlooded() == false) {
				flood(n.getLeft(), bacteria);
			}
		}
		catch(Exception e) {}
		try {
			if(n.getUp().getData() == bacteria && n.getUp().isFlooded() == false) {
				flood(n.getUp(), bacteria);
			}
		}
		catch(Exception e) {}
		return count;
	}
}
