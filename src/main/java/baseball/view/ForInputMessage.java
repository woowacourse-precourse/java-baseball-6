package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class ForInputMessage {
    private static final String FOR_INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String FOR_RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public String InputUserNumbers() {
        System.out.print(FOR_INPUT_NUMBER_MESSAGE);
        return Console.readLine();
    }

    public String InputRestart() {
        System.out.println(FOR_RESTART_MESSAGE);
        return Console.readLine();
    }

}
