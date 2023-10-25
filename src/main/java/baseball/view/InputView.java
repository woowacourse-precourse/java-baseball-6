package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_NUMBER_MSG = "숫자를 입력해주세요 : ";
    private static final String SELECT_REPLAY_MSG = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요. ";

    public String inputNumberMsg() {
        System.out.print(INPUT_NUMBER_MSG);
        return Console.readLine();
    }

    public String askReplayMsg() {
        System.out.print(SELECT_REPLAY_MSG);
        return Console.readLine();
    }
}