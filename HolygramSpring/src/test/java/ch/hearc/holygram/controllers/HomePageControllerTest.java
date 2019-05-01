package ch.hearc.holygram.controllers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import ch.hearc.holygram.service.UnitTestExampleService;

//@RunWith(SpringRunner.class)
//@WebMvcTest(HomePageController.class)
//public class HomePageControllerTest {
//	@Autowired
//	private MockMvc mvc;
//	
//	@MockBean
//	private UnitTestExampleService service;
//
//	@Test
//	public void whenCallUnitTestApi_thenResponseIsCorrect() throws Exception {
//		String data = service.homePage();
//		Mockito.when(data).thenReturn("ok");
//	}
//}
