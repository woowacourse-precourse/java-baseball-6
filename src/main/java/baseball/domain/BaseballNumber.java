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

    public boolean hasNumber(int number) {
        return first == number || second == number || third == number;
    }

    public boolean matchesAtPosition(int number, int position) {
        switch (position) {
            case 0:
                return first == number;
            case 1:
                return second == number;
            case 2:
                return third == number;
            default:
                return false;
        }
    }

    public int getNumberAtPosition(int position) {
        switch (position) {
            case 0:
                return first;
            case 1:
                return second;
            case 2:
                return third;
            default:
                return -1;
        }
    }
}