package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String RETRY = "1";
    private static final String END_GAME = "2";
    private static final String INVALID_INPUT_MESSAGE = "올바른 수를 입력하세요.";

    public static String inputPlayerNumbers() {
        System.out.print(INPUT_MESSAGE);
        return Console.readLine();
    }

    public static boolean shouldContinue() {
        System.out.println(RESTART_MESSAGE);
        String userInput = Console.readLine();
        if (RETRY.equals(userInput)) {
            return true;
        }
        if (END_GAME.equals(userInput)) {
            return false;
        }
        throw new IllegalArgumentException(INVALID_INPUT_MESSAGE);
    }

    private InputView() {
    }
}
