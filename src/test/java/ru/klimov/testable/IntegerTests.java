package ru.klimov.testable;

public class IntegerTests implements EqualsContract<Integer>, ComparableContract<Integer> {

    @Override
    public Integer createValue() {
        return 15;
    }

    @Override
    public Integer createSmallerValue() {
        return 10;
    }

    @Override
    public Integer createNotEqualValue() {
        return 5;
    }
}
