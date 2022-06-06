package com.dummy.potter.rest_tutorial;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

public class SampleTests {
    private String someInitState;

    @BeforeAll
    static void initBeforeAll(){
        System.out.println("Init before all !!");
    }

    @AfterAll
    static void destroyAfterAll(){
        System.out.println("Destroying after all !!");
    }

    @BeforeEach
    void init(){
        System.out.println("Initializing for test.");
        someInitState = "INITIALIZED";
    }

    @AfterEach
    void destroy(){
        someInitState = null;
        System.out.println("Destroyed after test");
    }

    @Test
    void testAPI(){
        String act = "o"+"k";
        Assertions.assertEquals("ok", act, "test API should return ok");
    }

    @Test
    @DisplayName("In-progress Dev Test, should not run")
    @Disabled
    void progressDevTest(){
        Assertions.fail("in progress Test, should not run !!");
    }

    @Test
    @DisplayName("Divide by 0")
    void arithmeticTest(){
        Assertions.assertThrows(ArithmeticException.class, ()->{int val = 1/0;}, "divide by zero test");
    }

    @Test
    @EnabledOnOs(OS.LINUX)
    @DisplayName("Linux only test")
    void linuxTest(){
        System.out.println("Linux Test ran !!");
    }

    @Test
    @DisplayName("Test after Server init")
    void testOnServer(){
        boolean isServerUp = false;
        Assumptions.assumeTrue(isServerUp);
        Assertions.assertEquals("up","up","health check resonse");
    }

    @Test
    @DisplayName("AssertAll")
    void assertAllTest(){
        Assertions.assertAll(
                () -> Assertions.assertEquals("ok", "ok", "assertAll-1"),
                () -> Assertions.assertEquals("not-ok", "not-ok", "assertAll-2")
        );
    }
}
