package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String GET_BASEBALL_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String GET_EXIT_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n";

    public String getBaseballNumber()  {
        System.out.print(GET_BASEBALL_NUMBER_MESSAGE);
        return Console.readLine();
    }

    public String getExit() {
        System.out.print(GET_EXIT_MESSAGE);
        return Console.readLine();
    }
}
