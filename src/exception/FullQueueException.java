package exception;

@SuppressWarnings("serial")
public class FullQueueException extends Exception{
	public FullQueueException(String string){
		super(string);
	}
}
