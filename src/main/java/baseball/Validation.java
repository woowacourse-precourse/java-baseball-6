package baseball;

import java.util.Arrays;

public class Validation {
    private static final int INPUT_DIGIT = 3;
    private static final int MIN_RANGE_NUM = 1;
    private static final int MAX_RANGE_NUM = 9;


    public static void validateNonNumeric(String input) { //숫자가 아닐 때
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수로 입력해주세요.");
        }
    }

    public static void validateDigit(String input) { //입력길이 오류
        if (input.length() != INPUT_DIGIT) {
            throw new IllegalArgumentException("입력길이 오류");
        }
    }

    public static void validateDuplicateNumber(String input) { //중복숫자
        String[] numbers = input.split("");
        if (numbers.length != Arrays.stream(numbers).distinct().count()) {
            throw new IllegalArgumentException("중복된 숫자입니다.");
        }
    }

    public static void validateRange(String input) {//숫자범위 넘을 때
        String[] numbers = input.split("");
        for (String number : numbers) {
            int tmp = Integer.parseInt(number);
            if (tmp < MIN_RANGE_NUM || tmp > MAX_RANGE_NUM) {
                throw new IllegalArgumentException("1~9까지의 정수를 입력해주세요.");
            }
        }
    }

}
