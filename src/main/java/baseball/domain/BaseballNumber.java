package baseball.domain;

import baseball.validation.BaseballNumberValidator;

public class BaseballNumber {
    private int first;
    private int second;
    private int third;

    public BaseballNumber(int first, int second, int third) {
        validateNumber(first, second, third);

        this.first = first;
        this.second = second;
        this.third = third;
    }

    private void validateNumber(int first, int second, int third) {
        BaseballNumberValidator.validate(first, second, third);
    }
}