package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    public static final String askNumberMessage = "숫자를 입력해주세요 : ";
    public static final String askRestartOrEndMessage = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public String getPlayerNumber() {
        System.out.print(askNumberMessage);
        return Console.readLine();
    }

    public String getRestartOrEnd() {
        System.out.println(askRestartOrEndMessage);
        return Console.readLine();
    }
}
