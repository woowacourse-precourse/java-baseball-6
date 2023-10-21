package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String requestUserNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        return Console.readLine();
    }

    public int requestGameRestart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String userInput = Console.readLine();

        if (!"1".equals(userInput) && !"2".equals(userInput)) {
            throw new IllegalArgumentException("1또는 2만 입력하세요.");
        }

        return Integer.parseInt(userInput);
    }


}
