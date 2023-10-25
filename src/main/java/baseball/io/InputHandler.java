package baseball.io;

import baseball.model.PlayerNumber;
import baseball.model.RetryOption;
import camp.nextstep.edu.missionutils.Console;

public class InputHandler {

    public static PlayerNumber getPlayerNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        return new PlayerNumber(input);
    }

    public static RetryOption getRetryOption() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
        String input = Console.readLine();
        return new RetryOption(input);
    }

}
