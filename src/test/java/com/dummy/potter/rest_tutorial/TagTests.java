package com.dummy.potter.rest_tutorial;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

public class TagTests {

    @Test
    @DisplayName("Divide by 0")
    @Tag("Important") // only tests of certain tag can be can using tag include/exclude conf in ide/surefire
    void arithmeticDivideByZeroTest(){
        Assertions.assertThrows(ArithmeticException.class, ()->{int val = 1/0;}, "divide by zero test");
    }

    @Test
    @DisplayName("Divide by 1")
    @Tag("Low")
    void arithmeticDivideByOneTest(){
        int val=3;
        Assertions.assertEquals(val/1, val, "divide by zero test");
    }

    @Test
    @DisplayName("Divide by 2")
    @Tags({@Tag("Important"), @Tag("Low")})
    void arithmeticDivideByTwoTest(){
        int val=10;
        Assertions.assertEquals(val/2, val/2, "divide by two test");
    }
}
