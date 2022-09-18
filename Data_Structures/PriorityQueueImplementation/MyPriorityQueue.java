package PriorityQueueImplementation;
import java.util.Iterator;

public class MyPriorityQueue implements Iterable<Integer> {
	
	    private final int[] elements;
	    private int size;
	    private final int capacity;

	    MyPriorityQueue(final int size) {
	        this.capacity = size;
	        this.elements = new int[size];
	        this.size = 0;
	    }
        //this will help finding the left child
	    public static int left(final int i) {
	        return (2 * i + 1);
	    }
        //this will help finding the right child
	    public static int right(final int i) {
	        return (2 * i + 2);
	    }
        //this will help finding the parent of children
	    public static int parent(final int i) {
	        return (i - 1) / 2;
	    }

	    public void enqueue(final int data) throws PriorityQueueException {
	        if (this.size == this.capacity) {
	            throw new PriorityQueueException("PriorityQueue is full and cannot add element");
	        } else {
	            this.size++;
	            this.elements[this.size - 1] = data;
	            int i = this.size - 1;
	            while (i != 0 && this.elements[MyPriorityQueue.parent(i)] > this.elements[i]) {
	                final int temp = this.elements[MyPriorityQueue.parent(i)];
	                this.elements[MyPriorityQueue.parent(i)] = this.elements[i];
	                this.elements[i] = temp;
	                i = MyPriorityQueue.parent(i);
	            }
	        }
	    }

	    public boolean dequeue(int element) throws PriorityQueueException
	    {
	        int elementIndex = containsIndex(element);
	        if(elementIndex != -1)
	        {
	            decreaseKey(elementIndex,Integer.MIN_VALUE);
	            extractMin();
	            return true;
	        }
	        throw new PriorityQueueException("PriorityQueue is Empty and cannot remove element");
	    }

	    public int extractMin() {
	        if (this.size == 0) {
	            return Integer.MAX_VALUE;
	        }
	        if (this.size == 1) {
	            this.size--;
	            return this.elements[this.size];
	        }

	        final int temp = this.elements[0];
	        this.elements[0] = this.elements[this.size - 1];
	        this.elements[this.size - 1] = temp;
	        this.size--;
	        this.minHeapify(0);
	        return this.elements[this.size];
	    }


	    public void minHeapify(final int i) {

	        final int left = MyPriorityQueue.left(i);
	        final int right = MyPriorityQueue.right(i);
	        int smallest = i;

	        if (left < this.size && this.elements[left] < this.elements[i]) {
	            smallest = left;
	        }

	        if (right < this.size && this.elements[right] < this.elements[smallest]) {
	            smallest = right;
	        }
	        if (smallest != i) {
	            final int temp = this.elements[i];
	            this.elements[i] = this.elements[smallest];
	            this.elements[smallest] = temp;
	            this.minHeapify(smallest);
	        }
	    }


	    public void print() {
	        for (int i = 0; i < this.size; i++) {
	            System.out.print(this.elements[i] + " ");
	        }
	        System.out.println();
	    }

	    public int peek() throws PriorityQueueException {
	        if (this.size != 0) {
	            return this.elements[0];
	        } else {
	            throw new PriorityQueueException("Priority Queue is empty");

	        }

	    }

	    public boolean contains(final int element) {
	        for (int i = 0; i < this.size; i++) {
	            if (this.elements[i] == element) {
	                return true;
	            }
	        }
	        return false;
	    }

	    public int containsIndex(final int element) {
	        for (int i = 0; i < this.size; i++) {
	            if (this.elements[i] == element) {
	                return i;
	            }
	        }
	        return -1;
	    }

	    public int size() {
	        return this.size;
	    }

	    public void reverse() {
	        for (int i = this.size - 1; i >= 0; i--) {
	            System.out.print(this.elements[i] + " ");
	        }
	        System.out.println();
	    }

	    public int center() throws PriorityQueueException{
	        if (this.size != 0) {
	            return this.elements[(this.size-1) / 2];
	        } else {
	            throw new PriorityQueueException("Priority queue is empty");
	        }
	    }

	    public void decreaseKey(int index, final int element) {
	        if (index < this.size) {
	            this.elements[index] = element;
	            while (index != 0 && this.elements[MyPriorityQueue.parent(index)] > this.elements[index]) {
	                final int temp = this.elements[index];
	                this.elements[index] = this.elements[MyPriorityQueue.parent(index)];
	                this.elements[MyPriorityQueue.parent(index)] = temp;
	                index = MyPriorityQueue.parent(index);
	            }
	        }
	    }


	    @Override
	    public Iterator<Integer> iterator() {
	        final Iterator<Integer> it = new Iterator<Integer>() {

	            private int currentIndex = 0;

	            @Override
	            public boolean hasNext() {
	                return this.currentIndex < size;
	            }

	            @Override
	            public Integer next() {
	                return elements[this.currentIndex++];
	            }

	            @Override
	            public void remove() {
	                throw new UnsupportedOperationException();
	            }
	        };
	        return it;
	    }

	}

