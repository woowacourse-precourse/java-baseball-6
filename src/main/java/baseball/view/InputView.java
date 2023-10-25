package baseball.view;

import baseball.model.Command;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String PLEASE_ENTER_NUMBER = "숫자를 입력해주세요 : ";
    private static final String PLEASE_ENTER_COMMAND = "게임을 새로 시작하려면 %s, 종료하려면 %s를 입력하세요.\n";

    public String readGuessNumber() {
        System.out.print(PLEASE_ENTER_NUMBER);
        return readLine();
    }

    public String readGameCommand() {
        System.out.printf(PLEASE_ENTER_COMMAND, Command.RESTART, Command.QUIT);
        return readLine();
    }

    protected String readLine() {
        return Console.readLine();
    }
}
