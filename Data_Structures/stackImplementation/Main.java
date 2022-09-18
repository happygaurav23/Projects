package stackImplementation;

import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
	
	
	public static void validatecapacity(int capacity) throws InvalidInputException{
		if(capacity <= 0 || capacity > Integer.MAX_VALUE) {
			throw new InvalidInputException("capacity of stack was invalid");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		try {
			System.out.println("Enter capacity of stack");
			int capacity = scn.nextInt();
			validatecapacity(capacity);
			Stack<Integer> st = new Stack<Integer>(capacity);
			while(true) {
			    System.out.println("Enter the operation you want to perform");
			    String input = scn.next();
			
				if(input.equals("push")) {
					System.out.println("Enter the elements you want to push");
					int n = scn.nextInt();
					while(n != 0) {
						st.push(scn.nextInt());
						n--;
					}
					continue;
				}else if(input.equals("pop")) {
					System.out.println("Enter how many elements you want to pop from the stack");
					int n = scn.nextInt();
					while(n != 0) {
						System.out.println("the popped element from stack was :- " + st.pop());
						n--;
					}
					continue;
				}else if(input.equals("peek")) {
					System.out.println("the top of stack will be :- " + st.peek());
					continue;
				}else if(input.equals("size")) {
					System.out.println("the size of the stack will be :- " + st.size());
					continue;
				}else if(input.equals("center")) {
					System.out.println("the center of the stack is :- " + st.center());
					continue;
				}else if(input.equals("contains")) {
					System.out.println("Enter data that you want to check whether that data is present in stack or not");
					int data = scn.nextInt();
					System.out.println(st.contains(data) == true ? "data was present in the stack":"data was not present in the stack");
					continue;
				}else if(input.equals("print")) {
					st.print();
					continue;
				}else if(input.equals("reverse")) {
					st.reverse();
					continue;
				}else if(input.equals("iterator")) {
					final Iterator<Integer> iterator = st.iterator();
					while (iterator.hasNext()) {
					    System.out.print(iterator.next() + " ");
					}
					continue;
				}else if(input.equals("sort")){
					st.sort();
					System.out.println("Sorted stack will be :- ");
					st.print();
					continue;
				}else {
					System.out.println("Invalid operation is entered by the user");
					break;
				}		
				
			}
			
		}catch(NullPointerException e) {
			System.out.println("Stack has no elements and null pointer exception is handled here");
			
		}catch(InputMismatchException e) {
			System.out.println("Input mismatch exception is handled here");
			
		}catch(InvalidInputException e) {
			System.out.println("Invalid input exception is handled here");
		}
		
		
		scn.close();

	}

}

@SuppressWarnings("serial")
class InvalidInputException extends Exception{
	
	InvalidInputException(String message){
		super(message);
	}
}
