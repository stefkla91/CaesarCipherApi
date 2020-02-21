package com.caesar.cipherapi.controller;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.caesar.cipherapi.CipherApiApplication;
import com.caesar.cipherapi.service.CipherService;

//@ExtendWith(MockitoExtension.class)
@RunWith(SpringRunner.class)
@SpringBootTest(classes = CipherApiApplication.class)
@AutoConfigureMockMvc
public class CipherControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private CipherService cipherServiceMock;
	
	@InjectMocks private CipherController cipherControllerMock;
	private final String encodingJson = "{\"message\": \"The quick brown Fox jumps over the lazy Dog\",	\"key\": 9}";
	
//	@Before
//	public void preTest() {
//		MockitoAnnotations.initMocks(this);
//		mockMvc = MockMvcBuilders.standaloneSetup(cipherControllerMock).build();
//	}
//	
	@Test
	public void encodingTest() throws Exception {
//		Mockito.when(cipherServiceMock.applyCipher(cipher))
		RequestBuilder requestBuilder = MockMvcRequestBuilders 
					.post("http://localhost:8080/cipher/encode")
					.accept(MediaType.APPLICATION_JSON).content(encodingJson)
					.contentType(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		
		assertEquals(HttpStatus.OK.value(), response.getStatus());
		assertEquals("{\"message\": \"Cqn zdrlt kaxfw Oxg sdvyb xena cqn ujih Mxp\",  \"key\": 0}", response.getContentAsString());
	}
	
//	@Test
//	public void encodingTest() {
//		try {
//			mockMvc	
//				.perform(post("cipher/encode")
//						.content(encodingJson)
//						.contentType("application/json"))
//				.andDo(print())
//				.andExpect(status().isOk())
//				.andExpect((ResultMatcher) content().json("{\"message\": \"Cqn zdrlt kaxfw Oxg sdvyb xena cqn ujih Mxp\",  \"key\": 6}"));
//		} catch(Exception e) {
//			System.out.println("Exception :" +e);
//		}
//	}
}
