package baseball.domain.view;

import camp.nextstep.edu.missionutils.Console;

public class InputData {
    private static final String NUMBER_OF_USER_INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String GAME_RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    private InputData() {
    }

    public static String inputUserBallNumber() {
        System.out.print(NUMBER_OF_USER_INPUT_MESSAGE);
        return Console.readLine();
    }

    public static String inputIsGameRestart() {
        System.out.println(GAME_RESTART_MESSAGE);
        return Console.readLine();
    }
}
