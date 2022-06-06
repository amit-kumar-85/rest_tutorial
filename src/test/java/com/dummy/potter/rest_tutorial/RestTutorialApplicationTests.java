package com.dummy.potter.rest_tutorial;

import com.dummy.potter.rest_tutorial.controller.PetsController;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @SpringBootTest loads the spring context
 */
@SpringBootTest
class RestTutorialApplicationTests {

	@Autowired
	private PetsController controller;

	@Test
	void testAPI(){
		Assertions.assertEquals("ok",controller.test(),"test API should return ok");
	}

}
