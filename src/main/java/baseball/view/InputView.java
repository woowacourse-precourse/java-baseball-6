package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_NUMBER = "숫자를 입력해주세요 : ";
    private static final String INPUT_RETRY = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public String readNumber() {
        System.out.print(INPUT_NUMBER);
        return Console.readLine();
    }

    public String readRetry() {
        System.out.println(INPUT_RETRY);
        return Console.readLine();
    }
}
