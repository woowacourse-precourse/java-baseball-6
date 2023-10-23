package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String inputMessage = "숫자를 입력해주세요 : ";
    private static final String restartMessage = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public String inputBaseballNumber() {
        System.out.print(inputMessage);
        return Console.readLine();
    }

    public String inputRestartNumber() {
        System.out.println(restartMessage);
        return Console.readLine();
    }
}