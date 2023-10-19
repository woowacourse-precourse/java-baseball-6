package baseball;

import static baseball.PlayerInput.NEW_GAME;
import static baseball.PlayerInput.QUIT_GAME;

import java.util.Arrays;

/**
 * 사용자의 메뉴 입력을 검증하는 클래스.
 * <p>단순한 입력 검증이 목표이며, 검증 성공 여부만을 알려준다. 추가적인 예외 발생 등은 PlayerInput에서 처리한다.
 */
public class PlayerMenuInputValidator {
    private static final int MENU_LENGTH = 1;

    public static boolean validateMenuString(String playerInput) {
        return validateLength(playerInput) &&
                validateStringOnlyHasDigits(playerInput) &&
                validateMenuNumber(Integer.parseInt(playerInput));
    }

    private static boolean validateStringOnlyHasDigits(String playerInput) {
        for (Character c : playerInput.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    private static boolean validateLength(String playerInput) {
        return playerInput.length() == MENU_LENGTH;
    }

    private static boolean validateMenuNumber(int menuNumber) {
        return menuNumber == NEW_GAME ||
                menuNumber == QUIT_GAME;
    }
}
