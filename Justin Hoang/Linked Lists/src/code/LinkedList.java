package code;

public class LinkedList {
	private Node first;
	private Node last;
	private int size;
	
	public LinkedList() {
		first = null;
		last = null;
		size = 0;
	}
	  
	public void push(int data) {
		Node temp = new Node(data);
		if(first == null) 
			first = temp;
		else {
			last.setNext(temp);
			temp.setPrev(last);
		}
		last = temp;
		size++;
	}
	
	public Node find(int target) {
		Node temp = first;
		while(temp!=null) {
			if(temp.getData() == target) 
				return temp;
			temp = temp.getNext();
		}
		return null;
	}
	
	public void display() {
		if(first != null) {
			Node temp = first;
			while(temp!=null) {
				System.out.print(temp.getData() + " ");
				temp = temp.getNext();
			}
			System.out.println();
			
			temp = last;  
			while(temp!=null) {
				System.out.print(temp.getData() + " ");
				temp = temp.getPrev();
			}
			
			System.out.println();
			//System.out.println("Size: " + size);
		}
	}
	
	public void pop() {
		if(last == first) {
			last = null;
			first = null;
			size--;
		}
		else  {
			last = last.getPrev();
			last.setNext(null);
			size--;
		}
	}
	
	public void pop(int target) {
		Node temp = find(target);
		if(first == null) {}
		else if(temp == last) 
			pop();
		else if(temp == first) {
			first = first.getNext();
			first.setPrev(null);
		}
		else {
			temp.getPrev().setNext(temp.getNext());
			temp.getNext().setPrev(temp.getPrev());
		}	
	}
	
	public void swap(int target1, int target2) {
		Node node1 = find(target1);
		Node node2 = find(target2);
		
		boolean inOrder = false;
		Node temp = node1;
		while(temp!=null) {
			if(temp == node2) {
				inOrder = true;
				break;
			}
			temp=temp.getNext();
		}
		if(inOrder == false) {
			temp = node1;
			node1 = node2;
			node2 = temp;
		}
		//same node
		if(node1 == node2) {}
		//first and last
		else if(node1 == first && node2 == last) {
			temp = node2;
			Node temp2 = node2.getPrev();
			node2.getPrev().setNext(node1);
			node1.getNext().setPrev(node2);
			node2.setNext(node1.getNext());
			node1.setPrev(temp2);
			node1.setNext(null);
			node2.setPrev(null);
			first = node2;
			last = node1;
		}
		//first and adjacent
		else if(node1 == first && node1.getNext() == node2) {
			node1.setNext(node2.getNext());
			node2.setNext(node1);
			node1.getNext().setPrev(node1);
			node1.setPrev(node2);
			node2.setPrev(null);
			first = node2;
		}
		//first and 1 apart
		else if(node1 == first && node1.getNext().getNext() == node2) {
			node1.setNext(node2.getNext());
			node2.getPrev().setNext(node1);
			node2.setNext(node2.getPrev());
			node2.setPrev(null);
			node2.getNext().setPrev(node2);
			node1.getNext().setPrev(node1);
			node1.setPrev(node2.getNext());
			first = node2;
		}
		//first and 2 or more apart
		else if(node1 == first) {
			temp = node1.getNext();
			Node temp2 = node2.getPrev();
			node1.setNext(node2.getNext());
			node2.setNext(temp);
			temp2.setNext(node1);
			temp.setPrev(node2);
			node2.setPrev(null);
			node1.getNext().setPrev(node1);
			node1.setPrev(temp2);
			first = node2;
		}
		//last and adjacent
		else if(node2==last && node2.getPrev() == node1) {
			node2.setNext(node1);
			node1.getPrev().setNext(node2);
			node2.setPrev(node1.getPrev());
			node1.setPrev(node2);
			node1.setNext(null);
			last=node1;
		}
		//last and 1 apart
		else if(node2==last && node2.getPrev().getPrev() == node1) {
			node2.setPrev(node1.getPrev());
			node1.getPrev().setNext(node2);
			node1.getNext().setNext(node1);
			node1.getNext().setPrev(node2);
			node1.setPrev(node1.getNext());
			node2.setNext(node1.getPrev());
			node1.setNext(null);
			last = node1;
			
		}
		//last and 2 or more apart
		else if(node2 == last) {
			temp = node2.getPrev();
			node1.getPrev().setNext(node2);
			node2.getPrev().setNext(node1);
			node2.setPrev(node1.getPrev());
			node2.setNext(node1.getNext());
			node1.getNext().setPrev(node2);
			node1.setPrev(temp);
			node1.setNext(null);
			last = node1;
		}
		//adjacent
		else if(node1.getNext() == node2) {
			node1.setNext(node2.getNext());
			node1.getPrev().setNext(node2);
			node2.getNext().setPrev(node1);
			node2.setPrev(node1.getPrev());
			node2.setNext(node1);
			node1.setPrev(node2);
			
		}
		//1 apart
		else if(node1.getNext().getNext() == node2) {
			node1.getPrev().setNext(node2);
			node1.setNext(node2.getNext());
			node2.setNext(node2.getPrev());
			node2.setPrev(node1.getPrev());
			node2.getNext().setNext(node1);
			node1.getNext().setPrev(node1);
			node1.setPrev(node2.getNext());
			node1.getPrev().setPrev(node2);
		}
		//2 or more apart
		else if(node1.getNext().getNext() != node2) {
			temp = node2.getNext();
			Node temp2 = node2.getPrev();
			node1.getPrev().setNext(node2);
			node2.setNext(node1.getNext());
			node2.getPrev().setNext(node1);
			node1.setNext(temp);
			node2.setPrev(node1.getPrev());
			temp.setPrev(node1);
			node1.setPrev(temp2);
			node2.getNext().setPrev(node2);
		}
	}
}
