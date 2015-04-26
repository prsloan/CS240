
import java.util.Stack;
import java.lang.String;
import java.util.Scanner;
import java.lang.Character;


/**
 * Project3 Description: This program will ask the user for
 * an infix expression and then output the postfix and prefix 
 * versions of that expression.  The conversion methods implement
 * the Stack data structure to convert the expression.
 * 
 * Date: July 27th, 2014
 * Class: CS240
 * 
 * @author prsloan
 *
 */
public class Project3 {

	public static void main(String args[]) {
	Project3 p = new Project3();
	Scanner s = new Scanner(System.in);
	String userInput="";
	
	do{
		userInput ="";
		System.out.print("\nPlease Enter a infix equation :");
		userInput = s.nextLine();
		if(userInput.length()>0){
			try{
				System.out.println("\n Postfix :" + p.toPostfix(userInput));
				System.out.println("\n Prefix :" + p.toPrefix(userInput));
			}
			catch(IllegalArgumentException iae){
				System.out.println("\nThat is not a valid expression! Try again!\n");
				System.out.println("Reason :" + iae.getMessage());
			}
		}	
	}
	while(userInput.length()>0);
	System.out.println("\nThanks for using this program. Goodbye!");
	s.close();
	}
	
	
	/**toPrefix(String input)
	 * 
	 * Description : This method uses stacks to iterate in reverse through a 
	 * string, and place the elements in the correct order to display a 
	 * prefix version of the input.
	 * 
	 * 
	 * @param input  the infix expression to be converted
	 * @return prefix expression
	 */
	public String toPrefix(String input){
		Stack<Character> operator = new Stack<Character>() ;
		Stack<Character> prefix = new Stack<Character>() ;
		String output="";
		
		
		for(int i =input.length()-1;i>-1;i--){
			if (i==input.length()-1 && (isOperator(input.charAt(i)) || input.charAt(i)=='('))
				throw new IllegalArgumentException("Illegal Format");
			//space
			else if(input.charAt(i)==' ')
				i--;
			//operand
			else if(!isOperator(input.charAt(i)) && input.charAt(i)!='(' && input.charAt(i)!=')'){
					prefix.push(input.charAt(i));
			}
			//if operator
			else if(isOperator(input.charAt(i))){
				if(i>1 && isOperator(input.charAt(i-1)))//two operators next to each other
					throw new IllegalArgumentException("Illegal Format");
				//if higher precedence or empty, push on operator
				else if(operator.empty() || hasGreaterOrEqualPrecedence(input.charAt(i),operator.peek()))
					operator.push(input.charAt(i));
				else{
					do{
						prefix.push(operator.pop());
						if(operator.empty())
							break;
					}while(!hasGreaterOrEqualPrecedence(input.charAt(i),operator.peek()));
					operator.push(input.charAt(i));
				}
			}
			//right parentheses
			else if(input.charAt(i)==')')
				operator.push(input.charAt(i));
			//left parentheses
			else if(input.charAt(i)=='('){
				do{
					prefix.push(operator.pop());
					if (operator.empty())
						throw new IllegalArgumentException("Mismatched Parentheses");
				}while(operator.peek()!=')');
				operator.pop();
			}
		}//end of for loop
		//time to empty to operators that remain
		while(!operator.empty()){
			prefix.push(operator.pop());
		}
		
		while(!prefix.empty()){
			output+=prefix.pop();
		}
		
		return output;
		
		
	}// End of Method
	
	/**toPostfix(String)
	 * 
	 * Description: This method uses stacks to format an output string as 
	 * a postfix expression.
	 * 
	 * @param input
	 * @return
	 */
	public String toPostfix(String input){
		
		Stack<Character> operator = new Stack<Character>() ;
		String out = "";

		
		
		//Scan first element of string til end of string 
		for (int i=0; i< input.length();i++ ){
			//check for space, skip if it is
			if(input.charAt(i)==' ')
				i++;
			//check if left paren, if so, push
			else if(input.charAt(i)=='(')
				operator.push(input.charAt(i));
			//check to see if it is an operand, if so, add to the string
			else if(!isOperator(input.charAt(i)) && input.charAt(i)!=')'){
					out+=input.charAt(i);
			}
			//check if char is operator other then right or left paren(*, /, +, -, %)
			else if (isOperator(input.charAt(i))){
				//check if operator is first char in the input, if it is throw a format error
				if(i==0)
					throw new IllegalArgumentException("Invalid begining of expression");
				//compare precedence with top of stack 
				else{
					if (!operator.empty())
						while(!operator.empty() && operator.peek()!='(' &&  !hasHigherPrecedence(input.charAt(i),operator.peek())){
							out += operator.pop();
						}
					operator.push(input.charAt(i));
				}
			}
			//operator should be right paren now, so pop til lef
			else{
				if (i==0)
					throw new IllegalArgumentException("Invalid First Expression!");
				else
					do{
						if(operator.peek()!='(')
							out+= operator.pop();
						if (operator.empty())
							throw new IllegalArgumentException("Mismatched Parentheses");
					}while (operator.peek()!='(');
				if (!operator.empty())
					operator.pop();
			}	
			
		}
		//empty and remaining items in the stack
		while(!operator.empty()){
			//throw an error if there is a hanging paren still in the stack
			if(operator.peek()=='(')
				throw new IllegalArgumentException("Mismatched Parentheses");
			else
				out+=operator.pop();
		}	
		return out;
		
	}
	
	/**
	 * Method Description: This method will return true if the first char has
	 * greater or equal precedence to the second character.  For the purposes
	 * of this program, the right parentheses is equal to all other operators.
	 * 
	 * @param char1
	 * @param char2
	 * @return
	 */
	boolean hasGreaterOrEqualPrecedence(char char1, char char2){
		boolean output = false;
		
		 if(char1=='*'||char1=='/'||char1=='%' ){
			if(char2=='+' || char2=='-' || char2=='*' || char2=='/' || char2=='%' || char2==')')
				output = true;
			}
		 else if (char1=='+' || char1=='-')
			if(char2=='+' || char2=='-'||char2==')')
				output = true;
		 return output;
	}
	
	
	
	
	/**
	 * Method Description: This method will return true if char one
	 * has a higher precedence then char 2.
	 * 
	 * @param char1
	 * @param char2
	 * @return
	 */
	boolean hasHigherPrecedence(char char1, char char2){
		boolean isHigher = false;
		
		//if operator is higher then the other char
		if(char1=='*'||char1=='/'||char1=='%' )
			if(char2=='+' || char2=='-' )
				isHigher = true;
		
		
		//in all other cases the operator will be less then
		
		return isHigher;
		
	}
	
	/**
	 * This method will return true if a given character is an operator besides a 
	 * parentheses.
	 * 
	 * 
	 * @param in
	 * @return
	 */
	boolean isOperator(char in){
		if (in=='*' || in=='/'|| in=='+'|| in=='-'|| in=='%')
			return true;
		else
			return false;
	}
	

}
