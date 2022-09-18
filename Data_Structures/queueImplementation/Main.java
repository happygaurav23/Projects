package queueImplementation;

import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
	
	public static void validatecapacity(int capacity) throws InvalidInputException{
		if(capacity <= 0 || capacity > Integer.MAX_VALUE) {
			throw new InvalidInputException("Exception was handled here");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scn = new Scanner(System.in);
		try {
			System.out.println("Enter the capacity of the queue");
			int capacity = scn.nextInt();
			validatecapacity(capacity);
			
			MyQueue<Integer> q = new MyQueue<>(capacity);
			while(true) {
				System.out.println("Enter the operation you want to perform");
				String input = scn.next();
				if(input.equals("enqueue")) {
					System.out.println("Enter the elements you want to push in queue");
					int n = scn.nextInt();
					while(n != 0) {
						q.enqueue(scn.nextInt());
						n--;
					}
					continue;
				}else if(input.equals("dequeue")) {
					System.out.println("Enter how many elements you want to remove from the queue");
					int n = scn.nextInt();
					while(n != 0) {
						System.out.println("popped element from queue was :- " + q.dequeue());
						n--;
					}
					continue;
				}else if(input.equals("peek")) {
					System.out.println("the peek of the queue will be :- " + q.peek());
					continue;
				}else if(input.equals("size")) {
					System.out.println("The size of the queue will be :- " + q.size());
					continue;
				}else if(input.equals("print")) {
					q.print();
					continue;
				}else if(input.equals("reverse")) {
					q.reverse();
					continue;
				}else if(input.equals("sort")) {
					q.sort();
					System.out.println("Sorted queue will be :- ");
					q.print();
					continue;
				}else if(input.equals("center")) {
					System.out.println("the center of the queue is :- " + q.center());
					continue;
				}else if(input.equals("iterator")){
					
					continue;
				}else {
					System.out.println("Invalid operation is entered by the user");
					break;
				}
			}
			
		}catch(NullPointerException e){
			System.out.println("Null pointer exception is handled here");
			
		}catch(InputMismatchException e) {
			System.out.println("input was mis matched here");	
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
