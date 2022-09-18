package linkedListImplementation;

import java.util.Iterator;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		
		
		try {
            final MyLinkedList<Integer> linkedList = new MyLinkedList<>();
            while(true) {
            	System.out.println("Enter the operation you want to perform");
            	String input = scn.next();
            	if(input.equals("insert")) {
            		System.out.println("Enter how many elements you want to insert in the linked list");
            		int n = scn.nextInt();
            		while(n != 0) {
            			linkedList.insert(scn.nextInt());
            			n--;
            		}
            		continue;
            	}else if(input.equals("insertatposition")) {
            		System.out.println("Enter the position and data that you want to insert at");
            	    linkedList.insertAtPosition(scn.nextInt(), scn.nextInt());
            	    continue;
            	}else if(input.equals("delete")) {
            		System.out.println("Enter how many elements you want to delete");
            		int n = scn.nextInt();
            		while(n != 0) {
            			linkedList.delete(scn.nextInt());
            			n--;
            		}
            		continue;
            	}else if(input.equals("deleteatposition")) {
            		System.out.println("Enter the position and data that you want to delete at");
            		linkedList.deleteAtPosition(scn.nextInt());
            		continue;
            	}else if(input.equals("print")) {
            		 linkedList.print(); 
            		 continue;
            	}else if(input.equals("sort")) {
            		linkedList.sort();
            		continue;
            	}else if(input.equals("center")) {
            		 linkedList.center(); 
            		 continue;
            	}else if(input.equals("reverse")) {
            		linkedList.reverse();
            		continue;
            	}else if(input.equals("iterator")) {
            		final Iterator<Integer> iterator = linkedList.iterator();
                    while (iterator.hasNext()) {
                        System.out.print(iterator.next() + " ");  
                    }
                    continue;
            	}else if(input.equals("size")){
            		System.out.println("The size of the list is :- " + linkedList.size());   
            	}else {
            		System.out.println("Invalid operation is entered by the user");
            		break;
            	}
            }                                  

            
        }catch (LinkedListException e){
            System.out.println(e.toString());
        }catch(NullPointerException e) {
        	System.out.println("Null pointer exception is handled here");
        }
		
		scn.close();

	}

}
