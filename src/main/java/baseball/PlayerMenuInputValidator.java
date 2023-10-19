package baseball;

import static baseball.PlayerInput.NEW_GAME;
import static baseball.PlayerInput.QUIT_GAME;

/**
 * 사용자의 메뉴 입력을 검증하는 클래스.
 * <p>단순한 입력 검증이 목표이며, 검증 성공 여부만을 알려준다. 추가적인 예외 발생 등은 PlayerInput에서 처리한다.
 */
public class PlayerMenuInputValidator {

    public boolean validateMenu(int menuNumber) {
        return menuNumber == NEW_GAME ||
                menuNumber == QUIT_GAME;
    }
}
