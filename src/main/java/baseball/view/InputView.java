package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String REQUEST_USER_INPUT = "숫자를 입력해주세요 : ";
    private static final String REQUEST_RESTART_OR_NOT = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String RESTART = "1";
    private static final String QUIT = "2";
    private static final String INPUT_ERROR_MESSAGE = "1또는 2만 입력하세요.";

    public String requestUserNumber() {
        System.out.print(REQUEST_USER_INPUT);
        return Console.readLine();
    }

    public int requestGameRestart() {
        System.out.println(REQUEST_RESTART_OR_NOT);
        String userInput = Console.readLine();

        if (!RESTART.equals(userInput) && !QUIT.equals(userInput)) {
            throw new IllegalArgumentException(INPUT_ERROR_MESSAGE);
        }

        return Integer.parseInt(userInput);
    }

}
