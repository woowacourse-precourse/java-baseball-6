package baseball.view.console;

import baseball.domain.Command;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String readGuessedNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        return Console.readLine();
    }

    public String readCommand() {
        System.out.printf("게임을 새로 시작하려면 %s, 종료하려면 %s를 입력하세요.\n", Command.RETRY.getValue(), Command.EXIT.getValue());
        return Console.readLine();
    }
}
