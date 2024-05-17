package ru.klimov.extension_automatically;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("TestInfo Demo")
class TestInfoDemo {

    TestInfoDemo(TestInfo testInfo) {
        System.out.println("Constructor: " + testInfo.getDisplayName());
        System.out.println("Test class: " + testInfo.getTestClass().orElseThrow());
        assertEquals("TestInfo Demo", testInfo.getDisplayName());
    }

    @BeforeEach
    void init(TestInfo testInfo) {
        System.out.println("BerforeEach: " + testInfo.getDisplayName());
        String displayName = testInfo.getDisplayName();
        assertTrue(displayName.equals("TEST 1") || displayName.equals("test2()"));
    }

    @Test
    @DisplayName("TEST 1")
    @Tags({@Tag("my-tag"), @Tag("tag2")})
    void test1(TestInfo testInfo) {
        System.out.println("Tags:");
        testInfo.getTags().forEach(System.out::println);
        assertEquals("TEST 1", testInfo.getDisplayName());
        assertTrue(testInfo.getTags().contains("my-tag"));
    }

    @Test
    void test2() {
    }

}
