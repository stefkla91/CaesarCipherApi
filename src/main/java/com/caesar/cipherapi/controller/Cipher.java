package com.caesar.cipherapi.controller;

public class Cipher {

	private String message;
	private int key;
	
	public Cipher() {}
	
	public Cipher(String message) {
		this.message = message;
		this.key = 0;
	}
	
	public Cipher(String message, int key) {
		this.message = message;
		this.key = key;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}
}
