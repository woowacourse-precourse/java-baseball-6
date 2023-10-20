package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String INPUT_NUMBERS = "숫자를 입력해주세요 :";
    private static final String END_OR_RESTART = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public String endOrRestartInput() {
        System.out.println(END_OR_RESTART);
        return Console.readLine();
    }

    public String inputNumbers() {
        System.out.println(INPUT_NUMBERS);
        return Console.readLine();
    }
}
