package com.fileparser.parser;

public class ParserException extends RuntimeException {
	public ParserException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public ParserException(String message) {
		super(message);
	}
}
