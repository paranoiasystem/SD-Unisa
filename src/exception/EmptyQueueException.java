package exception;

@SuppressWarnings("serial")
public class EmptyQueueException extends Exception {
	public EmptyQueueException(String string) {
		super(string);
	}
}
