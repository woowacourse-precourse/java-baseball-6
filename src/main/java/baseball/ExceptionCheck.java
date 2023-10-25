package baseball;

import java.util.*;

import static baseball.Application.MAX_NUMBER_SIZE;

public class ExceptionCheck {
    private static final String ZERO = "0";
    private static final int NUMBER_RANGE_START = (int)'0';
    private static final int NUMBER_RANGE_END = (int)'9';

    public static void checkPlayerNumberInput(String playerNumber) {
        isLengthThree(playerNumber);
        notContainsZero(playerNumber);
        isNumber(playerNumber);
        isNotDuplicated(playerNumber);
    }
    // 입력값 길이 체크
    private static void isLengthThree(String playerNumber) {
        if (playerNumber.length() != MAX_NUMBER_SIZE) {
            throw new IllegalArgumentException("입력된 숫자가 3자리가 아닙니다.");
        }
    }
    // 입력값 0 포함 체크
    private static void notContainsZero(String playerNumber) {
        if (playerNumber.contains(ZERO)) {
            throw new IllegalArgumentException("입력된 숫자 중 0이 존재합니다.");
        }
    }
    // 입력값 숫자 체크
    private static void isNumber(String playerNumber) {
        char[] charArray = playerNumber.toCharArray();
        for (char element : charArray) {
            if ((int)element < NUMBER_RANGE_START || (int)element > NUMBER_RANGE_END) {
                throw new IllegalArgumentException("입력된 값 중 숫자가 아닌 값이 존재합니다.");
            }
        }
    }
    // 중복된 값 검사
    private static void isNotDuplicated(String playerNumber) {
        String[] inputArray = playerNumber.split("");
        Set<String> inputSet = new HashSet<>(List.of(inputArray));
        if (inputArray.length != inputSet.size()) {
            throw new IllegalArgumentException("중복된 숫자가 있습니다.");
        }
    }
    public static void checkRestartNumber(String restartNumber) {
        if (!restartNumber.equals("1") && !restartNumber.equals("2")) {
            throw new IllegalArgumentException("잘못된 값이 입력되었습니다.");
        }
    }
}

