package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class GameInput {
    /* static */
    private static final String INPUT_NUMBER = "숫자를 입력해주세요 : ";
    private static final String END_OR_RESTART = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";


    public String inputNumber() {
        System.out.print(INPUT_NUMBER);
        return Console.readLine();
    }

    public String inputEndOrRestart() {
        System.out.println(END_OR_RESTART);
        return Console.readLine();
    }
}
