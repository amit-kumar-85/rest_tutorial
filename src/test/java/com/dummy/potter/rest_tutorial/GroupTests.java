package com.dummy.potter.rest_tutorial;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("Sample Group Tests")
public class GroupTests {

    @Nested
    @DisplayName("Related group-1")
    class GroupTest1{
        @Test
        @DisplayName("Group test 11")
        void groupTest11(){
            Assertions.assertEquals(1,1,"literals should be equal");
        }

        @Test
        @DisplayName("Group Test 12")
        void groupTest12(){
            int expected = -1, actual = -1;
            // junit will execute the lambda only if test fails,
            Assertions.assertEquals(expected,actual,() -> "literals should be equal, expected: " + expected +", actual: "+actual);
        }
    }

    @Nested
    @DisplayName("Related group-2")
    class GroupTest2{
        @Test
        @DisplayName("Group test 21")
        void groupTest21(){
            Assertions.assertEquals(1,1,"literals should be equal");
        }

        @Test
        @DisplayName("Group Test 22")
        void groupTest22(){
            int expected = -1, actual = -1;
            // junit will execute the lambda only if test fails,
            Assertions.assertEquals(expected,actual,() -> "literals should be equal, expected: " + expected +", actual: "+actual);
        }
    }
}
