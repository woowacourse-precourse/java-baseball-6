package baseball.model;

import java.util.ArrayList;
import java.util.List;

public class NumbersValidator {
    private static final String INPUT_LENGTH_IS_NOT_VALID = "입력한 값의 길이가 3이 아닙니다.";
    private static final String INPUT_IS_NOT_CONSIST_OF_NUMBERS = "입력한 값에 숫자가 아닌 값이 포함되어 있습니다.";
    private static final String INPUT_NUMBER_IS_NOT_IN_RANGE = "입력한 값을 이루고 있는 숫자가 범위를 벗어났습니다.";
    private static final String INPUT_HAS_DUPLICATED_NUMBER = "입력한 값에 중복된 숫자가 포함되어 있습니다.";
    private static final int VALID_LENGTH = 3;
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;
    private static List<Integer> playerNum;

    // 입력한 값에 대한 유효성을 검증하고 IllegalArgumentException을 발생함
    public static boolean validate(String numbers) {
        if (!hasValidLength(numbers)) {
            throw new IllegalArgumentException(INPUT_LENGTH_IS_NOT_VALID);
        }
        if (!hasOnlyNumbers(numbers)) {
            throw new IllegalArgumentException(INPUT_IS_NOT_CONSIST_OF_NUMBERS);
        }
        convert(numbers); // 숫자로 이루어져 있다는 검증이 위의 두 개의 메서드를 통해 확인이 되었기 때문에 리스트로 변환
        if (!isInValidRange()) {
            throw new IllegalArgumentException(INPUT_NUMBER_IS_NOT_IN_RANGE);
        }
        if (hasDuplicatedNumbers()) {
            throw new IllegalArgumentException(INPUT_HAS_DUPLICATED_NUMBER);
        }
        return true;
    }

    // 입력한 값의 길이가 3인지 확인하는 메서드
    private static boolean hasValidLength(String numbers) {
        return numbers.length() == VALID_LENGTH;
    }

    // 입력한 값이 숫자로만 이루어져 있는지 확인하는 메서드
    private static boolean hasOnlyNumbers(String numbers) {
        return numbers.chars()
                .allMatch(Character::isDigit);
    }

    // 입력한 문자열을 정수형 리스트로 변환하는 메서드
    private static void convert(String numbers) {
        playerNum = new ArrayList<>();

        for (String s : numbers.split("")) {
            playerNum.add(Integer.parseInt(s));
        }
    }

    // 입력한 값이 1 ~ 9 사이에 존재하는 숫자들로 구성되어 있는지 확인하는 메서드
    private static boolean isInValidRange() {
        return playerNum.stream()
                .filter(number -> MIN_NUMBER <= number && number <= MAX_NUMBER)
                .count() == VALID_LENGTH;
    }

    // 입력한 값에 중복되는 숫자가 존재하는지 확인하는 메서드
    private static boolean hasDuplicatedNumbers() {
        return playerNum.stream()
                .distinct()
                .count() != VALID_LENGTH;
    }
}
