package ru.klimov.interfaces;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestInterfaceDemo implements
        TestLifecycleLogger,
        TimeExecutionLogger,
        TestInterfaceDynamicTestsDemo {

    @Test
    void isEqualValue() {
        assertEquals(1, "a".length(), "is always equal");
    }

    @Test
    void test2() throws InterruptedException {
        Thread.sleep(200);
        assertEquals(1, "a".length(), "is always equal");
    }
}
