package baseball.game.view;

import baseball.game.constant.Constants;
import camp.nextstep.edu.missionutils.Console;
import java.util.HashSet;

public class InputManager {
    public static String START_GAME_MESSAGE = "숫자 야구 게임을 시작합니다.";
    public static String REQUEST_INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    public static String ASK_RE_GAME = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public void printGameStartMessage() {
        System.out.println(START_GAME_MESSAGE);
    }

    public String requestInput() {
        System.out.print(REQUEST_INPUT_MESSAGE);
        return Console.readLine();
    }

    public String getBaseballNumberFromUser(InputManager inputManager) {
        String userBaseballNumber = "";
        while (true) {
            userBaseballNumber = inputManager.requestInput();
            boolean isOk = validateUserBaseballNumber(userBaseballNumber);
            if (isOk) {
                break;
            }
        }
        return userBaseballNumber;
    }

    public boolean validateUserBaseballNumber(String userBaseballNumber) {
        HashSet<Character> validateNumberList = new HashSet<>();
        for (int i = 0; i < userBaseballNumber.length(); i++) {
            validateNumberList.add(userBaseballNumber.charAt(i));
        }
        if (userBaseballNumber.length() != Constants.BASEBALL_SIZE) {
            throw new IllegalArgumentException();
        }
        return validateNumberList.size() == Constants.BASEBALL_SIZE;
    }

    public String askRegame() {
        System.out.println(ASK_RE_GAME);
        return Console.readLine();
    }
}
