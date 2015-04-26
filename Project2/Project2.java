/*
 * This program provides the skeleton to process multiple files from a directory
 * The direcotry name is provided in args[0] as I call "java Testdir hashingdata"
 */
import java.io.*;
import java.util.*;

/**
 * Project Description:
 * 	This project will read in a variety of scores from a series of files and use a hash table to organize
 * them.  Then the program will print out data regarding the populated table, and allow the user to 
 * search for data with the appropriate key.
 * 
 * 
 * @author Philip Sloan
 * date : July 17th , 2014
 */
class Project2 {
  public static void main(String[] args) throws IOException {
	 HashTable table = new HashTable(57); //make a new table of size 50  
	  
	  
    if (args.length < 1) {
        System.out.println("Error: Directory name is missing");
        System.out.println("Usage: java scoreProcess directory_name");
        return;
    }
    File directory = new File(args[0]); // args[0] contains the directory name
    File[] files = directory.listFiles(); // get the list of files from that directory

    File file;
    Scanner input,console;

    // process the arguments stores in args
    for (int i = 0; i < files.length; i++) {
      input = new Scanner(files[i]);

      //System.out.println("\nCurrent file name: " + files[i].getName());
      
      // no error checking done here, add your own
      String key = null;
      Double value = null;
      
      while (input.hasNext())    {
      	key = "";
      	while (!input.hasNextDouble()){
      		key += input.next() + " ";
      		}
      		value = new Double(input.next());
      	// #### insert the (key, value) pair into your hash table
      		table.put(key, value);
      	}
      	
      }
    
   String userInput ="";
   table.calculateMinMax();   //Once all the data is populated, calculate the min and the max averages.
   
   // Print the hash table data for the user.
   System.out.println("# of Colisions : " + table.getColisions());
   System.out.println("Size of Table :" + table.getSize());
   System.out.println("\n\n# of Names: "+ table.getNumItems());
   System.out.println("Minimum Average : "+ table.minimumScore);
   System.out.println(table.minimumTeam);
   System.out.println("Maximum Average : "+ table.maximumScore);
   System.out.println(table.maximumTeam); 
    
    console = new Scanner(System.in);
    
    System.out.println("Feel free to try different NFL cities.  type 'exit' when ready to quit!\n\n");  //let the user know how to quit.
    
    while (!userInput.equals("exit ")){
    System.out.print("Enter name : ");
    userInput = console.nextLine() + " ";
    if (!userInput.equals("exit "))
    	try{
    		System.out.println(userInput+" Average : "+ table.get(userInput).getAverage() + " # of Scores :" + table.get(userInput).getNumScores());
    	}
    	catch (NullPointerException npe){
    		System.out.println( userInput + "Not Found. Try Again");
    	}
    		
    else
    	System.out.println(" Thanks for using this program!");
    
    }
}
}
