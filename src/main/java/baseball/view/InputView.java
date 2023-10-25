package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String NUMBER_INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String RESTART_EXIT_INPUT_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public String askGuessingNumbers() {
        System.out.print(NUMBER_INPUT_MESSAGE);
        String userInputString = Console.readLine();
        return userInputString;
    }

    public String askRestartOrExitNumber() {
        System.out.println(RESTART_EXIT_INPUT_MESSAGE);
        String userInputRestartOrExitString = Console.readLine();
        return userInputRestartOrExitString;
    }
}
