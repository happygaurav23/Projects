package linkedListImplementation;

import java.util.Iterator;

class Node<T> {
    T val;
    @SuppressWarnings("rawtypes")
	Node next;

    Node(final T val) {
        this.val = val;
    }

}

public class MyLinkedList<T> implements Iterable<T> {
    @SuppressWarnings("rawtypes")
	private Node head;
    private int size;

    @SuppressWarnings("unchecked")
	public void insert(final T data) {
        @SuppressWarnings("rawtypes")
		Node temp = this.head;
        this.size++;
        @SuppressWarnings({ "rawtypes" })
		final Node newNode = new Node(data);
        if (temp == null) {
            this.head = newNode;
        } else {
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }


    
    @SuppressWarnings({ "rawtypes", "unchecked" })
	public void insertAtPosition(final int position, final T data) throws LinkedListException {
        if (position <= this.size) {
            this.size++;
            Node temp = this.head;
            final Node newNode = new Node(data);
            int pos = 1;
            while (pos < position - 1) {
                temp = temp.next;
                pos++;
            }
            if (position == 1) {
                newNode.next = this.head;
                this.head = newNode;
            } else {
                final Node temp1 = temp.next;
                temp.next = newNode;
                newNode.next = temp1;
            }
        } else {
            throw new LinkedListException("Position out of LinkedList size");
        }
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
	public void delete(final T value) {
        Node curr = this.head;
        Node nextNode = this.head.next;

        if (curr.val.equals(value)) {
            this.head = this.head.next;
            this.size--;
        } else {
            while (nextNode != null && nextNode.val != value) {
                curr = nextNode;
                nextNode = nextNode.next;
            }
            if (nextNode != null) {
                this.size--;
                curr.next = curr.next.next;
            }
        }
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
	public void deleteAtPosition(final int position) {
        if (position <= this.size) {
            this.size--;
            if (position == 1) {
                this.head = this.head.next;
            } else {
                int pos = 1;
                Node temp = this.head;
                while (pos < position - 1) {
                    temp = temp.next;
                    pos++;
                }
                temp.next = temp.next.next;
            }
        } else {
            System.out.println("Position out of LinkedList size");
        }
    }


    @SuppressWarnings("rawtypes")
	public void center() throws LinkedListException {

        if (this.size != 0) {
            Node slow = this.head;
            Node fast = this.head.next;
            while (fast != null && fast.next != null) {
                slow = fast;
                fast = fast.next;
            }
            System.out.println(slow.val);
        } else {
            throw new LinkedListException("LinkedList is empty");
        }
    }

    public void sort() {
        //  System.out.println("SORT");
        this.head = this.mergeSort(this.head);

    }

    @SuppressWarnings({ "rawtypes", "unused", "unchecked" })
	public Node mergeSort(final Node node) {
        if (node == null || node.next == null) {
            return node;
        }
        final Node middle = MyLinkedList.middle(node);
        final Node left = middle;
        final Node right = middle.next;
        middle.next = null;
        return MyLinkedList.merge(this.mergeSort(node), this.mergeSort(right));
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
	public static Node merge(Node head1, Node head2) {
        // System.out.println("test");
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }
        Node newHead = null;
        Node tail = null;

        if ((int) head1.val <= (int) head2.val) {
            newHead = head1;
            tail = head1;
            head1 = head1.next;
        } else {
            newHead = head2;
            tail = head2;
            head2 = head2.next;
        }

        while (head1 != null && head2 != null) {
            if ((int) head1.val <= (int) head2.val) {
                tail.next = head1;
                tail = head1;
                head1 = head1.next;
            } else {
                tail.next = head2;
                tail = head2;
                head2 = head2.next;
            }
        }
        if (head1 == null) {
            tail.next = head2;
        }
        if (head2 == null) {
            tail.next = head1;
        }
        return newHead;
    }

    @SuppressWarnings("rawtypes")
	public static Node middle(final Node head) {
        if (head == null) {
            return null;
        }
        Node slow = head;
        Node fast = head.next;

        while (fast != null && fast.next != null) {
            slow = fast;
            fast = fast.next;
        }
        return slow;
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
	public void reverse() {
        if (this.size != 0 && this.size != 1) {
            Node curr = this.head;
            Node prev = null;

            while (this.head != null) {
                curr = this.head;
                this.head = this.head.next;
                curr.next = prev;
                prev = curr;
            }
            this.head = curr;
        }
    }
    
    public int size() {
        return this.size;
    }

    
    @SuppressWarnings("rawtypes")
	public void print() {
        Node temp = this.head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    @Override
    public Iterator<T> iterator() {
        final Iterator<T> it = new Iterator<T>() {

            private int currentIndex = 0;
            @SuppressWarnings("rawtypes")
			private Node temp = MyLinkedList.this.head;

            @Override
            public boolean hasNext() {
                return this.currentIndex < MyLinkedList.this.size && this.temp != null;
            }

            @SuppressWarnings({ "rawtypes", "unchecked" })
			@Override
            public T next() {
                final Node temp1 = this.temp;
                this.temp = this.temp.next;
                this.currentIndex++;
                return (T) temp1.val;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
        return it;
    }
}

@SuppressWarnings("serial")
class LinkedListException extends Exception{
    private String message;

    public LinkedListException(final String message) {
        super(message);
        this.message = message;
    }

    @Override
    public String toString() {
        return this.message;
    }
}
