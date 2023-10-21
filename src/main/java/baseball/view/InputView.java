package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_NUMBER = "숫자를 입력해주세요 : ";
    private static final String INPUT_RESTART_NUMBER = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public String inputNumber() {
        System.out.println(INPUT_NUMBER);
        return Console.readLine();
    }

    public String inputRestartNumber() {
        System.out.println(INPUT_RESTART_NUMBER);
        return Console.readLine();
    }
}
