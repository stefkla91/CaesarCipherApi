package com.caesar.cipherapi.service;

import org.springframework.stereotype.Service;

import com.caesar.cipherapi.controller.Cipher;

@Service
public class CipherService {
	
	public Cipher applyCipher(Cipher cipher){
		StringBuilder stringBuilder = new StringBuilder();
		char ch;

		for (int i = 0; i < cipher.getMessage().length(); i++) {
			if (Character.isWhitespace(cipher.getMessage().charAt(i))) { // whitespace
				ch = cipher.getMessage().charAt(i);
				stringBuilder.append(ch);
			} else if (Character.isUpperCase(cipher.getMessage().charAt(i))) { // Upper case letters
				if ((int) cipher.getMessage().charAt(i) + cipher.getKey() < 65) {
					// negative change -> reset to Z
					ch = (char) (((int) cipher.getMessage().charAt(i) + cipher.getKey() - 90) % 26 + 90);
				} else {
					ch = (char) (((int) cipher.getMessage().charAt(i) + cipher.getKey() - 65) % 26 + 65);
				}

				stringBuilder.append(ch);
			} else { // lower case letters
				if ((int) cipher.getMessage().charAt(i) + cipher.getKey() < 97) {
					// negative change -> reset to z
					ch = (char) (((int) cipher.getMessage().charAt(i) + cipher.getKey() - 122) % 26 + 122);
				} else {
					ch = (char) (((int) cipher.getMessage().charAt(i) + cipher.getKey() - 97) % 26 + 97);
				}
				stringBuilder.append(ch);
			}
		}
		return new Cipher(stringBuilder.toString());
	}
}
