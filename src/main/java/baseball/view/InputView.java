package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요  : ";
    private static final String INPUT_END_MESSAGE = "게임을 다시 시작하려면 1, 종료하려면 2를 입력하세요. \n";

    public String inputNumberMsg() {
        System.out.print(INPUT_NUMBER_MESSAGE);
        return Console.readLine();
    }

    public String inputEndMsg() {
        System.out.print(INPUT_END_MESSAGE);
        return Console.readLine();
    }
}

