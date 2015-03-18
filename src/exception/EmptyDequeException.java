package exception;

@SuppressWarnings("serial")
public class EmptyDequeException extends Exception {
	public EmptyDequeException(String string) {
		super(string);
	}
}
