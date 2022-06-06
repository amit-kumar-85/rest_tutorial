package com.dummy.potter.rest_tutorial;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestReporter;

@DisplayName("Test with dependencies")
public class TestsWithDependency {

    TestInfo testInfo;
    TestReporter testReporter;

    @BeforeEach
    void init(TestInfo testInfo, TestReporter testReporter){
        this.testInfo = testInfo;
        this.testReporter = testReporter;
    }

    @Test
    @DisplayName("Custom reporting test")
    @Tags({@Tag("Important"), @Tag("Important-lvl2")})
    void reportTest(){
        testReporter.publishEntry("running " + testInfo.getDisplayName() + " with tags: " + testInfo.getTags());
        Assertions.assertEquals(1, 1, "1 should be equal to 1");
    }
}
