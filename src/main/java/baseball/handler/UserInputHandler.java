package baseball.handler;

import camp.nextstep.edu.missionutils.Console;

public class UserInputHandler {

    public boolean askRestart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();

        if (!"1".equals(input) && !"2".equals(input)) {
            throw new IllegalArgumentException();
        }

        return "1".equals(input);
    }
}
