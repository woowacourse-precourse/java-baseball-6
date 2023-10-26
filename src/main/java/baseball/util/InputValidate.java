package baseball.util;

import java.util.List;
import java.util.TreeSet;

import static baseball.util.Constant.*;

public class InputValidate {

    /**
     * 입력값이 숫자가 아닌 문자 또는 특수문자일경우
     *
     * @param input
     */
    public static void validateNumberFormat(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }
    }

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
     * 게임종료 시 입력 값이 1 또는 2인지 검증
     */
    public static int validateRestartGame(int number) {
        if (number != FINISH && number != RESTART) {
            throw new IllegalArgumentException("1또는 2를 입력해야 합니다.");
        }

        return number;
    }

    /**
     * 중복된 숫자가 있는지 검증
     *
     * @param inputNumbers
     */
    public static void validateDuplicateNumbers(List<Integer> inputNumbers) {
        TreeSet<Integer> treeSet = new TreeSet<>(inputNumbers);
        if (treeSet.size() != NUMBER_THREE) {
            throw new IllegalArgumentException("중복된 숫자를 입력하였습니다.");
        }
    }
}
