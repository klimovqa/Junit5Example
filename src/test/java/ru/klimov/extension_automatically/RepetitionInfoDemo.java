package ru.klimov.extension_automatically;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;

public class RepetitionInfoDemo {

    @RepeatedTest(5)
    void testRepeat(RepetitionInfo repetitionInfo){
        System.out.println("Current repeat: "+ repetitionInfo.getCurrentRepetition());
        System.out.println("Fail test: "+ repetitionInfo.getFailureCount());
        if (repetitionInfo.getCurrentRepetition() == 3) {
            Assertions.fail();
        }
    }
}
