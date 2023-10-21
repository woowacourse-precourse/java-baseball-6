package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private final static String INSERT_ANSWER = "숫자를 입력해주세요 : ";
    private final static String INSERT_CONTINUE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public String readPlayersAnswer() {
        System.out.print(INSERT_ANSWER);
        return Console.readLine();
    }

    public String readPlayersContinue() {
        System.out.println(INSERT_CONTINUE);
        return Console.readLine();
    }
}
