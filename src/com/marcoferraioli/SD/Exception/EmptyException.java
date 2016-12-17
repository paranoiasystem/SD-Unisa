package com.marcoferraioli.SD.Exception;

public class EmptyException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public EmptyException(){
		super();
	}
	
	public EmptyException(String message){
		super(message);
	}

}
