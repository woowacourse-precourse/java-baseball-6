package baseball.util;

import static baseball.util.Constant.*;

public class InputValidate {

    /**
     * 입력값의 길이를 검증
     *
     * @param input
     */
    public static void validateLength(String[] input) {
        if (input.length != NUMBER_THREE) {
            throw new IllegalArgumentException("입력 값은 총 3자리여야 합니다.");
        }
    }

    /**
     * 입력값의 숫자가 1~9인지 검증
     *
     * @param number
     */
    public static void validateNumberRange(int number) {
        if (number < NUMBER_ONE || number > NUMBER_NINE) {
            throw new IllegalArgumentException("1부터 9사이의 숫자를 입력해야 합니다.");
        }
    }

    /**
     * 게임종료 시 1 또는 2인지 검증
     */
    public static int validateRestartGame(int number) {
        if (number != NUMBER_ONE && number != NUMBER_TWO) {
            throw new IllegalArgumentException("1부터 9사이의 숫자를 입력해야 합니다.");
        }

        return number;
    }
}
