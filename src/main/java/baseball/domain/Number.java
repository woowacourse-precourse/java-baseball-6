package baseball.domain;

import java.util.List;

public class Number {

    public static final String ERROR_MESSAGE = "[ERROR] ";
    public static final String OVER_NUMBER_SIZE_MESSAGE = "제시되는 수는 세자리 수 입니다";
    public static final String NOT_IN_DIGIT_RANGE = "각 자리수는 1- 9 사이 숫자입니다.";
    public static final int MIN_NUMBER_VALUE = 1;
    public static final int MAX_NUMBER_VALUE = 9;
    public static final int NUMBER_SIZE = 3;
    public List<Integer> number;

    public Number(List<Integer> number) {
        validate(number);
        this.number = number;
    }

    private void validate(List<Integer> number) {
        if (number.size() != NUMBER_SIZE) {
            throw new IllegalArgumentException(ERROR_MESSAGE + OVER_NUMBER_SIZE_MESSAGE);
        }
        if (number.size() != number.stream()
                .filter(n -> (n >= MIN_NUMBER_VALUE && n <= MAX_NUMBER_VALUE)).count()) {
            throw new IllegalArgumentException(ERROR_MESSAGE + NOT_IN_DIGIT_RANGE);
        }
    }

    public void setnumber(List<Integer> number) {
        this.number = number;
    }

}