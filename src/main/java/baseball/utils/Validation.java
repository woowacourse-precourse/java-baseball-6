package baseball.utils;

import java.util.List;

public class Validation {
    private static final int NUMBER_DIGIT = 3;
    private static final int START_INCLUSIVE_NUMBER = 1;
    private static final int END_INCLUSIVE_NUMBER = 9;
    private static final int GAME_REFRESH_INPUT = 1;
    private static final int GAME_FINISH_NUMBER = 2;
    private static final String NOT_THREE_DIGIT = "3자리 수가 아닙니다.";
    private static final String NOT_CONSIST_OF_NUMBER = "1~9의 숫자로 이루어져 있지 않습니다.";
    private static final String DUPLICATE_NUMBER = "숫자가 중복됐습니다.";
    private static final String INCORRECT_GAME_PROGRESS_INPUT = "올바르지 않은 게임 진행 입력입니다.";

    public static void verifyNumberDigit(List<Integer> numbers) {
        if (numbers.size() != NUMBER_DIGIT) {
            throw new IllegalArgumentException(NOT_THREE_DIGIT);
        }
    }

    public static void verifyConsistOfNumber(List<Integer> numbers) {
        int elementCount = (int) numbers.stream()
                .filter(e -> (e >= START_INCLUSIVE_NUMBER) && e <= (END_INCLUSIVE_NUMBER))
                .count();
        if (elementCount < NUMBER_DIGIT) {
            throw new IllegalArgumentException(NOT_CONSIST_OF_NUMBER);
        }
    }

    public static void verifyDuplicationNumber(List<Integer> numbers) {
        int elementCount = (int) numbers.stream()
                .distinct()
                .count();
        if (elementCount < NUMBER_DIGIT) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER);
        }
    }

    public static void verifyGameProgressInput(String input) {
        int convertedInput = Integer.parseInt(input);
        if (!(convertedInput == GAME_REFRESH_INPUT || convertedInput == GAME_FINISH_NUMBER)) {
            throw new IllegalArgumentException(INCORRECT_GAME_PROGRESS_INPUT);
        }
    }
}
