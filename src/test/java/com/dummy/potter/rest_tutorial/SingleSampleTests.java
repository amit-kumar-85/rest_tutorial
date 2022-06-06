package com.dummy.potter.rest_tutorial;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SingleSampleTests {
    String someState;

    @BeforeAll
    void init(){
        System.out.println("Before All init !!");
        someState = "INITIALIZED";
    }

    @BeforeEach
    void eachInit(){
        System.out.println("Before Each");
        someState = "particular state";
    }

    @AfterAll
    void destroy(){
        someState = null;
        System.out.println("After all destroy !!");
    }

    @Test
    void test1(){
        System.out.println("Single Sample Test 1 "+someState);
    }

    @Test
    void test12(){
        System.out.println("Single Sample Test 2 "+someState);
    }
}
