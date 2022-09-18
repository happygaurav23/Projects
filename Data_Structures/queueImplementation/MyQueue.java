package queueImplementation;

import java.util.Arrays;
import java.util.Iterator;

public class MyQueue<T> implements Iterable<T> {
	
	private T[] arr;
	private int front = 0;
	private int rear;
	private int size = 0;
	
	@SuppressWarnings("unchecked")
	public MyQueue(int capacity) {
		arr = (T[]) new Object[capacity];
		rear = arr.length-1;
	}
	
	public boolean isQueueCompletelyFilled() {
		if(size == arr.length) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean isQueueEmpty() {
		if(size == 0) {
			return true;
		}else {
			return false;
		}
	}
	
	public void enqueue(T data) {
		if(isQueueCompletelyFilled() != true) {
			rear = (rear + 1)%arr.length;
			arr[rear] = data;
			size++;
		}else {
			throw new IndexOutOfBoundsException("Queue is already completely filled");
		}
	}
	
	public T dequeue() {
		if(isQueueEmpty() != true) {
			T removed_value = arr[front];
			arr[front] = null;
			front = (front+1)%arr.length;
			size--;
			return removed_value;
		}else {
			System.out.println("Queue is empty");
			return null;
		}
	}
	
	public T peek() {
		if(size == 0) {
			return null;
		}else {
			return arr[front];
		}
	}
	
	public boolean contains(T data) {
		if(size == 0) {
			return false;
		}
		for(int i = front; i <= rear; i++) {
			T curr_value = arr[i];
			if(curr_value.equals(data)) {
				return true;
			}
		}
		
		return false;
	}
	
	public void sort() {
		if(size == 0) {
			System.out.println("queue is empty");
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
	
	public T center() {
		if(size == 0) {
			System.out.println("queue is empty");
			return null;
		}
		
		return arr[(front + rear)/2];
	}
	
	public void reverse() {
		if(size == 0) {
			System.out.println("queue is empty");
			return;
		}
		
		for(int i = rear; i >= front; i--) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		
	}
	
	public int size() {
		return size;
	}
	
	public void print() {
		
		if(size == 0) {
			System.out.println("queue is empty");
			return;
		}
		System.out.print("Queue elements are :- ");
		for(int i = front; i <= rear; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	@Override
	public Iterator<T> iterator() {
	    final Iterator<T> it = new Iterator<T>() {

	        private int currentIndex = 0;
	        int temp = MyQueue.this.front;
	        @Override
	        public boolean hasNext() {
	            return this.currentIndex++ < MyQueue.this.size;
	        }

	        @Override
	        public T next() {
	            final int temp2 = this.temp;
	            this.temp = (this.temp + 1) % MyQueue.this.size;
	            return MyQueue.this.arr[temp2];
	        }

	        @Override
	        public void remove() {
	            throw new UnsupportedOperationException();
	        }
	    };
	    return it;
	}

	

}
