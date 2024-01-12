package code;

public class LinkedGrid {
	Node start;
	
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
	public void flood(int newNumber) {
		flood(start, newNumber);
	}
	
	public void flood(Node n, int newNumber){
		int oldNumber = n.getData();
		n.setData(newNumber);
		
		try {
			if(n.getRight().getData() == oldNumber)
				flood(n.getRight(), newNumber);
		}
		catch(Exception e) {}
		try {
			if(n.getDown().getData() == oldNumber)
				flood(n.getDown(), newNumber);
		}
		catch(Exception e) {}
		try {
			if(n.getLeft().getData() == oldNumber)
				flood(n.getLeft(), newNumber);
		}
		catch(Exception e) {}
		try {
			if(n.getUp().getData() == oldNumber)
				flood(n.getUp(), newNumber);
		}
		catch(Exception e) {}
	}
	
	public boolean filled() {
		Node n = start;
		Node rowMarker = start;
		while(n.getDown() != null) {
			while(n.getRight() != null) {
				n = n.getRight();
				if(n.getData() != start.getData())
					return false;
			}
			n = rowMarker.getDown();
			if(n.getData() != start.getData())
				return false;
			rowMarker = rowMarker.getDown();
		}
		return true;
	}
	
	
}
