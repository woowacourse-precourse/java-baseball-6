package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    private static final String inputMessage = "숫자를 입력해주세요 : ";
    public String inputBalls() {
        System.out.print(inputMessage);
        return Console.readLine();
    }
}

