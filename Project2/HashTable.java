import java.lang.String ;
import java.util.Arrays;



/**
 * Class Description:  The table will implement seperate chaining to deal with collisions.
 * The hash node class will be used to store the data, and the hash function is a cyclic shift
 * function that works to minimize collisions.
 * 
 * @author Philip Sloan
 *
 */
public class HashTable {
	
	HashNode[] table;
	int itemsInTable=0;
	int colisions = 0;  //to track collisions
	protected final int DEFAULT_SIZE=100; 
	double maximumScore = 0;
	double minimumScore = 0;
	int size = 0;
	boolean[] indexOccupied;
	String minimumTeam;
	String maximumTeam;
	
	
	
	/**
	 * 
	 */
	HashTable(){
		table = new HashNode[DEFAULT_SIZE];
		size = DEFAULT_SIZE;
		indexOccupied = new boolean[DEFAULT_SIZE];
		Arrays.fill(indexOccupied, false);
	}
	
	
	/**
	 * This is the constructor that will create a hash table of linked lists to hold the teams
	 * scores.  The table will also keep track of whether a particular spot is occupied or not,
	 * and how many items are in the table at any given time.
	 * @param size
	 */
	HashTable(int size){
		table = new HashNode[size];
		itemsInTable = 0;
		this.size = size;
		indexOccupied = new boolean[size];
		Arrays.fill(indexOccupied, false);
	}
	
	
	
	
	
	/**
	 * By cycling through items a particular index in the table, the data gets placed
	 * either in a new node or in the matching node that is at the location where the hash code sent
	 * it.
	 * 
	 * @param key
	 * @param data
	 */
	boolean put(String key, double data){
		//store the hash code
		int i = hash(key);
		
		//to navigate a list at an index
		
		//set the min and max if the table is empty
		if(itemsInTable == 0){
			minimumScore = data;
			maximumScore = data;
		}
			
		
	
		for (HashNode p=table[i]; p!=null ; p=p.next){
				if(key.equals(p.key)){
					p.addScore(data);
					
				return true;	
			}
		}
		if (indexOccupied[i])
			colisions++;
		table[i] = new HashNode(table[i], data, key);
		indexOccupied[i] = true;
		itemsInTable++;
		return true;
			
				
}
		
	
	
	/**
	 * This function will return the node at the location for the given key.  If
	 * the key does not exist in the table, then the method will throw an exception.
	 * @param key
	 * @return
	 */
	HashNode get(String key){
		//store the hash code
		int i = hash(key);
		
		
		
		
		if(itemsInTable == 0)
			throw new NullPointerException();
		else if (!indexOccupied[i])
			throw new NullPointerException();
		else 
			for (HashNode p=table[i]; p!=null ; p=p.next){
				if(key.equals(p.key))
					return p;
				if(p.next == null)
					throw new NullPointerException();
			}
		return null;
		
		
		
		
	}
	
	
	
	/**
	 * The hash function will take a given key in the form of a string, and apply a bit shift function along with summing
	 * to create unique hash codes to place the values in the table.
	 * 
	 * @param key
	 * @return
	 */
	int hash(String key){
		int hashCode = 0;
		
		//The hash code will be a cyclic shift because the values are strings.
		for (int i = 0; i < key.length(); i++) {
		    hashCode = (hashCode << 7) | (hashCode >>> 31); // 5-bit cyclic shift of the running sum
		    hashCode += (int) key.charAt(i); // add in next character
		   
		}
		//Now make sure the hashCode falls within the size of the table
		hashCode = Math.abs(hashCode%size);
		
		return hashCode;
	
	}
	
	
	/**
	 * When called, this method will cycle through all of the items in the table and assign a
	 * minimum average and a maximum average.
	 */
	void calculateMinMax(){
		
		for (int i=0;i<size;i++){
			if (indexOccupied[i])
				for (HashNode p=table[i]; p!=null ; p=p.next){
					if (p.getAverage()>maximumScore){
						maximumScore = p.getAverage();
						maximumTeam = p.getKey();
					}
					else if (p.getAverage()<minimumScore){
						minimumScore = p.getAverage();
						minimumTeam = p.getKey();
					}
				}
		}
		
	}
	
	
	
	/**
	 * 
	 * @return
	 */
	int getSize(){
		return size;
	}
	
	/**
	 * 
	 * @return
	 */
	int getNumItems(){
		return itemsInTable;
	}
	
	/**
	 * 
	 * @return
	 */
	int getColisions(){
		return colisions;
	}
	
	
	
	
	
	
	
}
