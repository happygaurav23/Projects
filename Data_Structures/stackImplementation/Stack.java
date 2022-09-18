package stackImplementation;
import java.util.Arrays;
import java.util.Iterator;

	public class Stack<Type> implements Iterable<Type> {
		private Type[] arr;
		private int index;
		
		@SuppressWarnings("unchecked")
		public Stack(int capacity) {
			arr = (Type[])new Object[capacity];
			index = -1;
			
		}
		
		
		public void push(Type data) {
			if(index >= arr.length-1) {
				System.out.println("Stack overflow");
				return;
			}else {
				arr[++index] = data;
			}
		}
		
		public Type pop() {
			if(index == -1) {
				System.out.println("Stack underflow");
				return null;
			}else {
				Type removed_value = arr[index];
				arr[index--] = null;
				return removed_value;
				
			}
		}
		
		public Type peek() {
			if(index == -1) {
				System.out.println("Stack underflow");
				return null;
			}else {
				return arr[index];
			}
		}
		
		public boolean contains(Type data) {
			for(int i = 0; i < index; i++) {
				Type curr_value = arr[i];
				if(curr_value.equals(data)) {
					return true;
				}
			}
			
			return false;
			
		}
		
		public int size() {
			return index + 1;
		}
		
		public Type center() {
			if(index == -1) {
				return null;
			}else if(arr.length == 1) {
				return arr[index];
			}else {
				return arr[index/2];
			}
			
			
		}
		
		public void sort() {
			if(index == -1) {
				System.out.println("Stack has no elements to sort");
				return;
			}
			Arrays.sort(this.arr, (o1, o2) -> {
		        if (o1 != null && o2 != null && (int) o1 < (int) o2) {
		            return -1;
		        } else {
		            return 1;
		        }
		    });
			
		}
		
		public Iterator<Type> iterator(){
			
			return new StackIterator();
			
		}
		
		private class StackIterator implements Iterator<Type>{
			private int top = index;
			
			public boolean hasNext() {
				return (top > -1);
			}
			public Type next() {
				return arr[top--];
			}
				
		}
		
		
		
		public void reverse() {
			if(index == -1) {
				System.out.println("Stack is empty and cannot be reversed");
				return;
			}else {
				for(int i = index; i >= 0; i--) {
					System.out.print(arr[i] + " ");
				}
				System.out.println();
			}
			
		}
		
		public void print() {
			if(index == -1) {
				System.out.println("Stack is empty");
				return;
			}else {
				System.out.print("Stack elements are :- ");
				for(int i = 0; i <= index; i++) {
					System.out.print(arr[i] + " ");
				}
				System.out.println();
			}
			
		}
		

	}

