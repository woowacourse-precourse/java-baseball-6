package baseball.global.util;

import static baseball.global.enums.Constant.FINISH_MENU;
import static baseball.global.enums.Constant.NUM_LENGTH;
import static baseball.global.enums.Constant.RESTART_MENU;
import static baseball.global.enums.ErrorMessage.DIFFERENT_THREE_DIGITS;
import static baseball.global.enums.ErrorMessage.EMPTY_INPUT_VALUE;
import static baseball.global.enums.ErrorMessage.INVALID_INPUT_VALUE;
import static baseball.global.enums.ErrorMessage.INVALID_MENU_CHOICE;
import static baseball.global.enums.ErrorMessage.NO_ZERO_IN_NUM;

/**
 * 사용자가 입력받는 값에 대한 처리만을 담당하는 클래스
 */
public final class GameInput {


    public static int validateMenu(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_INPUT_VALUE.message);
        }
        if (!input.equals(RESTART_MENU) && !input.equals(FINISH_MENU)) {
            throw new IllegalArgumentException(INVALID_MENU_CHOICE.message);
        }
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_MENU_CHOICE.message);
        }
    }

    public static void validateNum(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_INPUT_VALUE.message);
        }

        if (input.length() != NUM_LENGTH) {
            throw new IllegalArgumentException(DIFFERENT_THREE_DIGITS.message);
        }

        for (int i = 0; i < NUM_LENGTH; i++) {

            int digit;
            try {
                digit = Integer.parseInt(String.valueOf(input.charAt(i)));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(INVALID_INPUT_VALUE.message);
            }

            if (digit == 0) {
                throw new IllegalArgumentException(NO_ZERO_IN_NUM.message);
            }

        }
    }
}
