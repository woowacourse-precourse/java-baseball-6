package baseball.validator;

import java.util.HashSet;

import static baseball.constants.BaseballGameConstants.*;

public class Validator {

   private static final String RESTART_OR_END_ERROR_MASSAGE = "게임 재시작은 1,종료는 2를 입력하세요. 잘못된 값이 입력되었습니다.";
   private static final String DIGIT_ERROR_MESSAGE = "3자리가 아닙니다";
   private static final String NOT_INTEGER_MESSAGE = "입력한 값이 정수가 아닙니다.";
   private static final String DUPLICATION_MESSAGE = "입력한 값에 중복된 값이 있습니다.";
   private static final String CONTAIN_ZERO_MESSAGE = "입력한 값에 0이 있습니다. 1~9의 숫자를 입력하세요.";
    public static void isValidNumbers(String numbers) {
        if(!isValidDigit(numbers)){
            throw new IllegalArgumentException(DIGIT_ERROR_MESSAGE);
        }
        if (!isInteger(numbers)) {
            throw new IllegalArgumentException(NOT_INTEGER_MESSAGE);
        }
        if (hasDuplicate(numbers)) {
            throw new IllegalArgumentException(DUPLICATION_MESSAGE);
        }
        if (hasZero(numbers)) {
            throw new IllegalArgumentException(CONTAIN_ZERO_MESSAGE);
        }
    }

    /**
     *  입력된 값에 0이 있을 경우 isInteger()로 예외 처리가 안되므로
     *  hasZero()로 예외 처리를 해준다.
     */
    public static boolean hasZero(String numbers) {
        return numbers.contains(STRING_ZERO);
    }
    public static boolean isValidDigit(String numbers) {
        return numbers.length() == GAME_NUMBER_SIZE;
    }

    public static boolean hasDuplicate(String numbers) {
        HashSet<Character> set = new HashSet<>();
        for (char ch : numbers.toCharArray()) {
            set.add(ch);
        }
        if (set.size() != numbers.length()) {
            return true;
        }
        return false;
    }

    public static boolean isInteger(String numbers) {
        try {
            Integer.parseInt(numbers);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void isValidGameOption(String input) {
        if (!(input.equals(RESTART_OPTION) || input.equals(END_OPTION))) {
            throw new IllegalArgumentException(RESTART_OR_END_ERROR_MASSAGE);
        }
    }
}
