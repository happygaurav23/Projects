package PriorityQueueImplementation;

@SuppressWarnings("serial")
public class PriorityQueueException extends Exception {
	private final String message;
	public PriorityQueueException(final String message) {
		// TODO Auto-generated constructor stub
		    super(message);
		    this.message = message;
		    
	}

		@Override
		public String toString() {
		    return this.message;
		}
		
}
