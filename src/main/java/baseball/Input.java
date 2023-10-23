package baseball;

import baseball.domain.UserBalls;
import camp.nextstep.edu.missionutils.Console;

public class Input {
    private static final String inputMessage = "숫자를 입력해주세요 : ";
    public UserBalls inputBalls() {
        System.out.print(inputMessage);
        String input = Console.readLine();
        return new UserBalls(input);
    }
}

