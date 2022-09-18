package HashMapImplementation;

import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
	
	public static void validatecapacity(int capacity) throws InvalidInputException{
		if(capacity <= 0 || capacity > Integer.MAX_VALUE) {
			throw new InvalidInputException("Invalid input exception was caught here");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter capacity of the map");
		try {
			int capacity = scn.nextInt();
			validatecapacity(capacity);
			
			
			MyHashMap<String,Integer> map = new MyHashMap<>(capacity);
			while(true) {
				System.out.println("Enter the operation you want to perform");
				String input = scn.next();
				
				if(input.equals("insert")) {
					System.out.println("Enter how many elements you want to insert in the map");
					int n = scn.nextInt();
					while(n != 0) {
						map.insert(scn.next(), scn.nextInt());
						n--;
					}
					continue;
				}else if(input.equals("delete")) {
					System.out.println("Enter how many elements you want to remove from the map");
					int n = scn.nextInt();
					while(n != 0) {
						System.out.println("the removed value from the map will be :- " + map.Delete("Paris"));
						n--;
					}
					continue;
					
				}else if(input.equals("size")) {
					System.out.println("The size of the map will be :- " + map.size());
					continue;
				}else if(input.equals("containskey")) {
					System.out.println(map.containsKey("USA")== true?"key was present in the map":"key was not present in the map");
					continue;
				}else if(input.equals("getvaluebykey")) {
					System.out.println("The value will be :- " + map.GetValueByKey("London"));
					continue;
				}else if(input.equals("print")) {
					map.print();
					continue;
				}else if(input.equals("iterator")) {
					@SuppressWarnings("rawtypes")
					Iterator<MyHashMap.HashMapNode> it = map.iterator();
					while (it.hasNext()) {
						@SuppressWarnings("rawtypes")
						MyHashMap.HashMapNode node = it.next();
					    System.out.println("Key -> " + node.key + ", Value -> " + node.value);
					}
					continue;
				}else {
					System.out.println("Invalid operation is entered by the user");
					break;
				}
			}
			
//			map.insert("India", 100);
//			map.insert("USA", 99);
//			map.insert("London", 101);
//			map.insert("Dublin", 98);
//			map.insert("Paris", 97);
//			map.insert("France", 201);
//			
			
			
		}catch(NullPointerException e) {
			System.out.println("Null pointer exception is handled here");
		}catch(InputMismatchException e) {
			System.out.println("Input is mis matched here");
		}catch(InvalidInputException e) {
			System.out.println("Invalid input exception is handled here");
		}
		
		
		scn.close();
		

	}

}

@SuppressWarnings("serial")
class InvalidInputException extends Exception{
	InvalidInputException(String response){
		super(response);
	}
}
