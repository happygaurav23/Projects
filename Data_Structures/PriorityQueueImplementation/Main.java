package PriorityQueueImplementation;

import java.util.Iterator;
import java.util.Scanner;


public class Main {
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		
		try {
			System.out.println("Enter the capacity of the priority queue");
			int capacity = scn.nextInt();
			if(capacity <= 0 || capacity > Integer.MAX_VALUE) {
				System.out.println("Invalid capacity is entered by the user");
				return;
			}
			
            final MyPriorityQueue pq = new MyPriorityQueue(capacity);
            while(true) {
            	System.out.println("Enter the operation you want to perform");
            	String input = scn.next();
            	if(input.equals("enqueue")) {
            		System.out.println("Enter how many elements you want to add in priority queue");
            		int n = scn.nextInt();
            		while(n != 0) {
            			pq.enqueue(scn.nextInt());
            			n--;
            		}
            		continue;
            	}else if(input.equals("dequeue")) {
            		System.out.println("Enter how many elements you want to remove from the priority queue");
            		int n = scn.nextInt();
            		while(n != 0) {
            			System.out.println(pq.dequeue(scn.nextInt())); 
            			n--;
            		}
            		continue;
            		
            	}else if(input.equals("peek")) {
            		  System.out.println(pq.peek());
            		  continue;
            	}else if(input.equals("size")) {
            		System.out.println("The size of the priority queue will be :- " + pq.size());
            		continue;
            	}else if(input.equals("print")) {
            		  pq.print();
            		  continue;
            	}else if(input.equals("reverse")) {
            		  pq.reverse();
            		  continue;
            	}else if(input.equals("iterator")) {
            		final Iterator<Integer> it = pq.iterator();
                    while (it.hasNext()) {
                        System.out.print(it.next() + " ");
                    }
                    continue;
            	}else {
            		System.out.println("Invalid operation is entered by the user");
            		break;
            	}
            }
          
        }catch (PriorityQueueException e) {
            System.out.println(e.toString());
        }catch(NullPointerException e) {
        	System.out.println("Null pointer exception is handled here");
        }

    }


}
