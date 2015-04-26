import java.lang.String ;


/**
 * Class Description:  This class is the Node class to implement linked lists for 
 * the seperate chaining hash table.  It will keep track of the total of all the scores
 * entered, the average score, and the number of scores entered.
 * 
 * 
 * @author Philip Sloan
 *
 */
public class HashNode {

	
	HashNode next;
	double sumScore = 0;
	double average = 0;
	int numScores = 0;
	String key;
	
	
	/**
	 * The Default Constuctor.
	 */
	HashNode(){
		
	}
	
	
	/**
	 * Creates a new Node with the values passsed in from the function call.
	 * 
	 * @param next  This is the next node in the list
	 * @param score This is the score that will be a running sum of the items being added in.
	 * @param key This is the key that determines the location in the hash table.
	 */
	HashNode(HashNode next, double score, String key){
		numScores++;
		sumScore = score;
		this.next = next;
		this.key = key;
		average = 0;
	}
	
	
	/**
	 * This updates the next node value.
	 * @param newNext
	 */
	void setNext(HashNode newNext){
		next = newNext; 
	}
	
	/**
	 *  
	 * @return The average of this particular node.
	 */
	double getAverage(){
		return average;
	}
	
	/**
	 * 
	 * @return the next node.
	 */
	HashNode getNext(){
		return next;
	}
	/**
	 * 
	 * @return the number of values that have been entered in for this particular node
	 */
	int getNumScores(){
		return numScores;
	}
	
	
	/**
	 * This function adds value to the sum of the scores
	 * 
	 * @param score
	 */
	void addScore(double score){
		sumScore+=score;
		numScores++;
		average = sumScore/numScores;
	}
	
	/**
	 * 
	 * @return the key for this node.
	 */
	String getKey(){
		return key;
	}
	
	
}
