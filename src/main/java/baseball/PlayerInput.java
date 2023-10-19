package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

/**
 * 사용자의 입력을 받는 클래스. 검증과 함께 작동하며, 검증에 실패하는 경우 예외를 발생한다. 예외는 이곳에서만 발생한다. 사용자가 입력하는 값은
 * <code>{@link Console}</code> API를 활용한다.
 * <p>정답을 추측하는 경우 1부터 9까지의 세 자리 수로 제한되며, 각 자릿수는 모두 달라야 한다.
 * <p>메뉴를 선택하는 경우, 1 또는 2로 제한된다.
 */
public class PlayerInput {
    public static final int NEW_GAME = 1;
    public static final int QUIT_GAME = 2;

    public List<Integer> getPlayerNumbers() {
        String playerInput = Console.readLine();
        List<Integer> playerNumbers = new ArrayList<>();
        for (int index = 0; index < playerInput.length(); index++) {
            int number = playerInput.charAt(index) - '0';
            playerNumbers.add(number);
        }
        if (!PlayerNumbersInputValidator.validatePlayerNumbers(playerNumbers)) {
            throw new IllegalArgumentException();
        }
        return playerNumbers;
    }
}
