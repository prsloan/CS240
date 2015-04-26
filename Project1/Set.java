/************************************************
 * Project 1
 * description: this project will create a singly linked list
 * to create a set of numeric values.  Various methods will provide 
 * functionality to the set so that it can be expanded or compared to 
 * other sets
 * 
 * @author Phil Sloan
 * @date  July 8th, 2014
 */





public class Set {

	protected Node head; 
	protected String name;
	protected int size;
	
	//Default constructor method, creates an empty set with a dummy head
	public Set(){
		head = new Node(null, null);
		size = 0;
	}
	
	//Overloaded constructor that will populate the name variable with a name
	public Set(String name){
		this.name = name;
		head = new Node(null, null);
		size = 0;
	}
	
	//getNth will take in a location in the list and return the Node at that location
	public Node getNth(int location){
		Node current = head;
		
		if (location>size)
			return current;
		for (int i=0; i<location;i++)
			current = current.getNext();
		return current;
	}
	
	
	//contain: returns Boolean value.  Returns true if the given object is contained in the set and false otherwise. 
	public boolean contains(Object e){
		Node temp = head.getNext();
		
		while (temp != null){
			if (temp.getElement() == e)
				return true;
			temp = temp.getNext();
			}
		return false;
	}
	
	
	//remove: returns Boolean value.  Returns true if the node containing the object is removed from the set and false otherwise.
	public boolean remove(Object e){
		boolean success = false;
		Node current = head;
		Node next = head.getNext();
		
		if (this.contains(e))
			while (next != null){
				if (next.getElement()==e){
					current.setNext(next.getNext());
					next.setNext(null);
					size--;
					success =  true;			
					}
				current = next;
				next = next.getNext();
				}
		else
			success = false;
		
		return success;				
	}
	//this method will reset the set to empty by simply pointing the head node to null
	public void removeAll(){
		head.setNext(null);
		size = 0;
	}
	

	//addElement: returns Boolean value.  Returns false if element not added because it is already in the set and true if the element is added.
	public boolean addElement(Object e){
		Node temp = head;
		
		if (this.contains(e))
			return false;
		else{
			while (temp.getNext() !=null)
				temp = temp.getNext();
			temp.setNext(new Node(e, null));
			size++;
			return true;
		}
			
	}
	//size: returns an integer equal to the number of distinct objects are in the Set.
	public int getSize(){
		return size;
	}
	//subsetOf: returns a Boolean value true if every element in set A is in set B and false otherwise.
	public boolean subsetOf(Set b){
		
		boolean isSubset = false;
		Node current = head.getNext();
		int subsetCount = 0;
		
		if (size == 0){
			isSubset = true;
			return isSubset;
			}
		
		while (current.getNext()!=null){
			if (b.contains(current.getElement())) 
				subsetCount++;
			current = current.getNext();
		}
		if (subsetCount== size)
			isSubset = true;
		return isSubset;
		
	}
	//isEqual: returns true if both sets contain the same elements where order in either set does not count.
	public boolean isEqual(Set b){
		
		boolean equal = false;
		
		if ((this.subsetOf(b)) && (size == b.getSize()))
			equal = true;
		
		return equal;
		
	}
	//union: if A, B, C are sets, has the form C = A.union(B). Union returns a Set that contains all the elements in set A and B, but only list duplicates once.
	public Set union(Set b){
		
		Set newSet = new Set();
		
		Node current = head.getNext();
		
			while (current!=null){
				newSet.addElement(current.getElement());
				current = current.getNext();
				}
			for (int i=0;i<b.getSize();i++){
				current = b.getNth(i+1);
				if(!newSet.contains(current.getElement()))
					newSet.addElement(current.getElement());
				}
			
		
		return newSet;
	}
	//intersection: if A, B, C are sets, has form C = A.intersection(B) and returns a set containing only elements that are common to both A and B, but no duplicates.
	public Set intersection(Set b){
		
		Set intersect = new Set();
		
		Node current = head.getNext();
		
		if((this.subsetOf(b))||(this.isEqual(b)))
			return this;
		else
			while (current!=null){
				if( b.contains(current.getElement()))
					intersect.addElement(current.getElement());
				current = current.getNext();
			}
		return intersect;
	}
	//complement: if A, B, C are sets, has form C = A.complement(B) and returns a set containing only elements that are in A but not in B. 
	public Set complement(Set b){
		
		Node current = head.getNext();
		
		Set complement = new Set();
		
		while (current!=null){
			if (!b.contains(current.getElement()))
				complement.addElement(current.getElement());
			current = current.getNext();	
			}
	
		return complement;
	}
	//toString: displays a message that indicates an object's state. An object's state is the data that is stored in the object's fields at any giving moment.

	public String toString(){
		Node current = head.getNext();
		
		StringBuilder setContents = new StringBuilder();
		
		while(current!=null){
			setContents.append(current.getElement()+" ");
			current = current.getNext();
			}
		
		return setContents.toString();
	}
	
	
	
}
