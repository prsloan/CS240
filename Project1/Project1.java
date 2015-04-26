/*
 * The test program will work through all of the methods in the set class through 5 different cases and will
 * pring the results to the console.
 */


public class Project1 {


	
	public static void main(String args[]){
		
		
		
		//Case 1: A and B are equal but distinct sets, for example, A = {1, 2, 3}, B = {2, 1, 3} 
		//Initialize the two sets as equal, but distinct
		Set A = new Set(), 
			B = new Set(),
			C = new Set();
		
		A.addElement(2);
		A.addElement(4);
		A.addElement(5);
		
		B.addElement(5);
		B.addElement(2);
		B.addElement(4);
		
		System.out.println(" Case 1 : \n\t Set 1: " +A.toString()+" Set 2: "+B.toString());
		
		// test contain: returns Boolean value.  Returns true if the given object is contained in the set and false otherwise. 
		System.out.println("\nTest if Set 1 contains the value '2' ");
		if (A.contains(2))
			System.out.println(" Set 1 contains the number 2");
		else
			System.out.println(" Set 1 does not contain '2'.");
		
		// test remove: returns Boolean value.  Returns true if the node containing the object is removed from the set and false otherwise.
		System.out.println("\n Test the removal of an element ");
		if (A.remove(2))
			System.out.println(" '2' was successfully removed from Set 1 \n Set 1: " +A.toString());
		else
			System.out.println(" '2' was not removed from the set.");
		
		//Test the adding of an element
		System.out.println("\n Add '2' back to Set 1 ");
		if (A.addElement(2))
			System.out.println(" '2' was Successfully added to Set 1.");
		else
			System.out.println(" '2' was not Successfully added to the set.");
		// test size: returns an integer equal to the number of distinct objects are in the Set.
		System.out.println("\n The current Size of set 1 is : "+A.getSize()+
							"\n The current size of Set 2 is: "+B.getSize());
		
		// test subsetOf: returns a Boolean value true if every element in set A is in set B and false otherwise.
		System.out.println(" \n Test if Set 1 is a subset of Set 2");
		if (A.subsetOf(B))
			System.out.println(" Set 1 is a subset of Set 2!");
		else
			System.out.println( " Set 1 is not a subset of Set 2");
		
		// test isEqual: returns true if both sets contain the same elements where order in either set does not count.
		System.out.println("\n Test is Set 1 is Equal to Set 2.");
		if (A.isEqual(B))
			System.out.println(" Set 1 is equal to Set 2");
		else
			System.out.println(" Set 1 is not equal to Set 2");
		
		//test union: if A, B, C are sets, has the form C = A.union(B). Union returns a Set that contains all the elements in set A and B, but only list duplicates once.
		System.out.println("\n Test is Set 1 union Set 2.");
		C= A.union(B);
		System.out.println(" New Set : " +C.toString());
		
		// test intersection: if A, B, C are sets, has form C = A.intersection(B) and returns a set containing only elements that are common to both A and B, but no duplicates.
		System.out.println("\n Test Set 1 intersection Set 2");
		C = A.intersection(B);
		System.out.println(" New Set : "+C.toString());
		
		// test complement: if A, B, C are sets, has form C = A.complement(B) and returns a set containing only elements that are in A but not in B. 
		System.out.println("\n Test Set 1 complement Set 2");
		C = A.complement(B);
		System.out.println(" New Set : "+C.toString());
		
		// test toString: displays a message that indicates an object's state. An object's state is the data that is stored in the object's fields at any giving moment.
		System.out.println("\n Test toString() method. ");
		System.out.println("\n \tSet 1: "+A.toString()+ "\n\tSet 2: "+B.toString());
		
		
		
		
		
		
		//Case 2: A and B are such that they have different sizes but one is a subset of the other, for example, A = {1}, B = {1, 2}
			
			
			System.out.println("\n\n****************************************************************\n\n");
			
			
			B.addElement(9);
			B.addElement(12);
			
			System.out.println(" Case 2 : \n\t Set 1: " +A.toString()+" Set 2: "+B.toString());
			
			// test contain: returns Boolean value.  Returns true if the given object is contained in the set and false otherwise. 
			System.out.println("Test if Set 1 contains the value '2' ");
			if (A.contains(2))
				System.out.println(" Set 1 contains the number 2");
			else
				System.out.println(" Set 1 does not contain '2'.");
			
			// test remove: returns Boolean value.  Returns true if the node containing the object is removed from the set and false otherwise.
			System.out.println("\n Test the removal of an element ");
			if (A.remove(2))
				System.out.println(" '2' was successfully removed from Set 1 \n Set 1: " +A.toString());
			else
				System.out.println(" '2' was not removed from the set.");
			
			//Test the adding of an element
			System.out.println("\n Add '2' back to Set 1 ");
			if (A.addElement(2))
				System.out.println(" '2' was Successfully added to Set 1.");
			else
				System.out.println(" '2' was not Successfully added to the set.");
			// test size: returns an integer equal to the number of distinct objects are in the Set.
			System.out.println("\n The current Size of set 1 is : "+A.getSize()+
								"\n The current size of Set 2 is: "+B.getSize());
			
			// test subsetOf: returns a Boolean value true if every element in set A is in set B and false otherwise.
			System.out.println(" \n Test if Set 1 is a subset of Set 2");
			if (A.subsetOf(B))
				System.out.println(" Set 1 is a subset of Set 2!");
			else
				System.out.println( " Set 1 is not a subset of Set 2");
			
			// test isEqual: returns true if both sets contain the same elements where order in either set does not count.
			System.out.println("\n Test is Set 1 is Equal to Set 2.");
			if (A.isEqual(B))
				System.out.println(" Set 1 is equal to Set 2");
			else
				System.out.println(" Set 1 is not equal to Set 2");
			
			//test union: if A, B, C are sets, has the form C = A.union(B). Union returns a Set that contains all the elements in set A and B, but only list duplicates once.
			System.out.println("\n Test is Set 1 union Set 2.");
			C= A.union(B);
			System.out.println(" New Set : " +C.toString());
			
			// test intersection: if A, B, C are sets, has form C = A.intersection(B) and returns a set containing only elements that are common to both A and B, but no duplicates.
			System.out.println("\n Test Set 1 intersection Set 2");
			C = A.intersection(B);
			System.out.println(" New Set : "+C.toString());
			
			// test complement: if A, B, C are sets, has form C = A.complement(B) and returns a set containing only elements that are in A but not in B. 
			System.out.println("\n Test Set 2 complement Set 1");
			C = B.complement(A);
			System.out.println(" New Set : "+C.toString());
			
			// test toString: displays a message that indicates an object's state. An object's state is the data that is stored in the object's fields at any giving moment.
			System.out.println("\n Test toString() method. ");
			System.out.println("\n \tSet 1: "+A.toString()+ "\n\tSet 2: "+B.toString());
			
			
		
		
		
		
		//Case 3: A and B are non-empty and different in size but have common elements, for example, A = {1, 2, 3}, B = {2, 3, 4, 5}
			A.removeAll();
			B.removeAll();
			C.removeAll();
			
			System.out.println("\n\n****************************************************************\n\n");
			
			A.addElement(1);
			A.addElement(3);
			A.addElement(4);
			A.addElement(5);
			A.addElement(7);
			A.addElement(9);
			
			B.addElement(3);
			B.addElement(7);
			B.addElement(9);
			B.addElement(6);
			B.addElement(8);
			
			
			System.out.println(" Case 3 : \n\t Set 1: " +A.toString()+" Set 2: "+B.toString());
			
			// test contain: returns Boolean value.  Returns true if the given object is contained in the set and false otherwise. 
			System.out.println("Test if Set 1 contains the value '2' ");
			if (A.contains(2))
				System.out.println(" Set 1 contains the number 2");
			else
				System.out.println(" Set 1 does not contain '2'.");
			
			// test remove: returns Boolean value.  Returns true if the node containing the object is removed from the set and false otherwise.
			System.out.println("\n Test the removal of an element ");
			if (A.remove(2))
				System.out.println(" '2' was successfully removed from Set 1 \n Set 1: " +A.toString());
			else
				System.out.println(" '2' was not removed from the set.");
			
			//Test the adding of an element
			System.out.println("\n Add '2' back to Set 1 ");
			if (A.addElement(2))
				System.out.println(" '2' was Successfully added to Set 1.");
			else
				System.out.println(" '2' was not Successfully added to the set.");
			// test size: returns an integer equal to the number of distinct objects are in the Set.
			System.out.println("\n The current Size of set 1 is : "+A.getSize()+
								"\n The current size of Set 2 is: "+B.getSize());
			
			// test subsetOf: returns a Boolean value true if every element in set A is in set B and false otherwise.
			System.out.println(" \n Test if Set 1 is a subset of Set 2");
			if (A.subsetOf(B))
				System.out.println(" Set 1 is a subset of Set 2!");
			else
				System.out.println( " Set 1 is not a subset of Set 2");
			
			// test isEqual: returns true if both sets contain the same elements where order in either set does not count.
			System.out.println("\n Test is Set 1 is Equal to Set 2.");
			if (A.isEqual(B))
				System.out.println(" Set 1 is equal to Set 2");
			else
				System.out.println(" Set 1 is not equal to Set 2");
			
			//test union: if A, B, C are sets, has the form C = A.union(B). Union returns a Set that contains all the elements in set A and B, but only list duplicates once.
			System.out.println("\n Test is Set 1 union Set 2.");
			C= A.union(B);
			System.out.println(" New Set : " +C.toString());
			
			// test intersection: if A, B, C are sets, has form C = A.intersection(B) and returns a set containing only elements that are common to both A and B, but no duplicates.
			System.out.println("\n Test Set 1 intersection Set 2");
			C = A.intersection(B);
			System.out.println(" New Set : "+C.toString());
			
			// test complement: if A, B, C are sets, has form C = A.complement(B) and returns a set containing only elements that are in A but not in B. 
			System.out.println("\n Test Set 2 complement Set 1");
			C = B.complement(A);
			System.out.println(" New Set : "+C.toString());
			
			// test toString: displays a message that indicates an object's state. An object's state is the data that is stored in the object's fields at any giving moment.
			System.out.println("\n Test toString() method. ");
			System.out.println("\n \tSet 1: "+A.toString()+ "\n\tSet 2: "+B.toString());
			
				
			
		//Case 4: they are non-empty with nothing in common, for example, A = {1}, B = {2, 3}, and 
			A.removeAll();
			B.removeAll();
			C.removeAll();
			
			System.out.println("\n\n****************************************************************\n\n");
			
			A.addElement(2);
			A.addElement(4);
			A.addElement(6);
			A.addElement(8);
			
			B.addElement(3);
			B.addElement(5);
			
			
			System.out.println(" Case 4 : \n\t Set 1: " +A.toString()+" Set 2: "+B.toString());
			
			// test contain: returns Boolean value.  Returns true if the given object is contained in the set and false otherwise. 
			System.out.println("Test if Set 1 contains the value '2' ");
			if (A.contains(2))
				System.out.println(" Set 1 contains the number 2");
			else
				System.out.println(" Set 1 does not contain '2'.");
			
			// test remove: returns Boolean value.  Returns true if the node containing the object is removed from the set and false otherwise.
			System.out.println("\n Test the removal of an element ");
			if (A.remove(2))
				System.out.println(" '2' was successfully removed from Set 1 \n Set 1: " +A.toString());
			else
				System.out.println(" '2' was not removed from the set.");
			
			//Test the adding of an element
			System.out.println("\n Add '2' back to Set 1 ");
			if (A.addElement(2))
				System.out.println(" '2' was Successfully added to Set 1.");
			else
				System.out.println(" '2' was not Successfully added to the set.");
			// test size: returns an integer equal to the number of distinct objects are in the Set.
			System.out.println("\n The current Size of set 1 is : "+A.getSize()+
								"\n The current size of Set 2 is: "+B.getSize());
			
			// test subsetOf: returns a Boolean value true if every element in set A is in set B and false otherwise.
			System.out.println(" \n Test if Set 1 is a subset of Set 2");
			if (A.subsetOf(B))
				System.out.println(" Set 1 is a subset of Set 2!");
			else
				System.out.println( " Set 1 is not a subset of Set 2");
			
			// test isEqual: returns true if both sets contain the same elements where order in either set does not count.
			System.out.println("\n Test is Set 1 is Equal to Set 2.");
			if (A.isEqual(B))
				System.out.println(" Set 1 is equal to Set 2");
			else
				System.out.println(" Set 1 is not equal to Set 2");
			
			//test union: if A, B, C are sets, has the form C = A.union(B). Union returns a Set that contains all the elements in set A and B, but only list duplicates once.
			System.out.println("\n Test is Set 1 union Set 2.");
			C= A.union(B);
			System.out.println(" New Set : " +C.toString());
			
			// test intersection: if A, B, C are sets, has form C = A.intersection(B) and returns a set containing only elements that are common to both A and B, but no duplicates.
			System.out.println("\n Test Set 1 intersection Set 2");
			C = A.intersection(B);
			System.out.println(" New Set : "+C.toString());
			
			// test complement: if A, B, C are sets, has form C = A.complement(B) and returns a set containing only elements that are in A but not in B. 
			System.out.println("\n Test Set 2 complement Set 1");
			C = B.complement(A);
			System.out.println(" New Set : "+C.toString());
			
			// test toString: displays a message that indicates an object's state. An object's state is the data that is stored in the object's fields at any giving moment.
			System.out.println("\n Test toString() method. ");
			System.out.println("\n \tSet 1: "+A.toString()+ "\n\tSet 2: "+B.toString());
		//Case 5: one is non-empty and the other empty.  
			A.removeAll();
			B.removeAll();
			C.removeAll();
			
			System.out.println("\n\n****************************************************************\n\n");
			
			B.addElement(3);
			B.addElement(4);
			B.addElement(5);
			
			
			System.out.println(" Case 5 : \n\t Set 1: " +A.toString()+" Set 2: "+B.toString());
			
			// test contain: returns Boolean value.  Returns true if the given object is contained in the set and false otherwise. 
			System.out.println("Test if Set 1 contains the value '2' ");
			if (A.contains(2))
				System.out.println(" Set 1 contains the number 2");
			else
				System.out.println(" Set 1 does not contain '2'.");
			
			// test remove: returns Boolean value.  Returns true if the node containing the object is removed from the set and false otherwise.
			System.out.println("\n Test the removal of an element ");
			if (A.remove(2))
				System.out.println(" '2' was successfully removed from Set 1 \n Set 1: " +A.toString());
			else
				System.out.println(" '2' was not removed from the set.");
			
			
			// test size: returns an integer equal to the number of distinct objects are in the Set.
			System.out.println("\n The current Size of set 1 is : "+A.getSize()+
								"\n The current size of Set 2 is: "+B.getSize());
			
			// test subsetOf: returns a Boolean value true if every element in set A is in set B and false otherwise.
			System.out.println(" \n Test if Set 1 is a subset of Set 2");
			if (A.subsetOf(B))
				System.out.println(" Set 1 is a subset of Set 2!");
			else
				System.out.println( " Set 1 is not a subset of Set 2");
			
			// test isEqual: returns true if both sets contain the same elements where order in either set does not count.
			System.out.println("\n Test is Set 1 is Equal to Set 2.");
			if (A.isEqual(B))
				System.out.println(" Set 1 is equal to Set 2");
			else
				System.out.println(" Set 1 is not equal to Set 2");
			
			//test union: if A, B, C are sets, has the form C = A.union(B). Union returns a Set that contains all the elements in set A and B, but only list duplicates once.
			System.out.println("\n Test is Set 1 union Set 2.");
			C= A.union(B);
			System.out.println(" New Set : " +C.toString());
			
			// test intersection: if A, B, C are sets, has form C = A.intersection(B) and returns a set containing only elements that are common to both A and B, but no duplicates.
			System.out.println("\n Test Set 1 intersection Set 2");
			C = A.intersection(B);
			System.out.println(" New Set : "+C.toString());
			
			// test complement: if A, B, C are sets, has form C = A.complement(B) and returns a set containing only elements that are in A but not in B. 
			System.out.println("\n Test Set 2 complement Set 1");
			C = B.complement(A);
			System.out.println(" New Set : "+C.toString());
			
			// test toString: displays a message that indicates an object's state. An object's state is the data that is stored in the object's fields at any giving moment.
			System.out.println("\n Test toString() method. ");
			System.out.println("\n \tSet 1: "+A.toString()+ "\n\tSet 2: "+B.toString());

		
	}
	
	
	
	
	
}
