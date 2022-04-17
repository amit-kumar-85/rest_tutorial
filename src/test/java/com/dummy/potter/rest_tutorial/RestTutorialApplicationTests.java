package com.dummy.potter.rest_tutorial;

import com.dummy.potter.rest_tutorial.controller.PetsController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RestTutorialApplicationTests {

	@Autowired
	private PetsController controller;

	@Test
	void contextLoads() {
		System.out.println("Tests ran !!");
	}

	@Test
	void testAPI(){
		System.out.println(controller.test().equals("ok"));
	}

}
