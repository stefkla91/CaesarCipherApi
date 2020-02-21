package com.caesar.cipherapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.caesar.cipherapi.service.CipherService;

@RestController
@RequestMapping("/cipher")
public class CipherController {

	@Autowired
	private CipherService cipherService;

	@PostMapping("/encode")
	public ResponseEntity<Cipher> encode(@RequestBody Cipher rawCipher) {
		Cipher encodedCipher = cipherService.applyCipher(rawCipher);

		return ResponseEntity.ok(encodedCipher);
	}

	@PostMapping("/decode")
	public ResponseEntity<Cipher> decode(@RequestBody Cipher rawCipher) {
		// in an decoding step we need to reverse the key
		rawCipher.setKey(-rawCipher.getKey());
		Cipher decodedCipher = cipherService.applyCipher(rawCipher);

		return ResponseEntity.ok(decodedCipher);
	}
}
