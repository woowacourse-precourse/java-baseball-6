package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static String inputUserNum() {
        System.out.print("숫자를 입력해주세요 : ");
        return Console.readLine();
    }

    public static String inputUserGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String userInput = Console.readLine();

        if (!userInput.equals("1") && !userInput.equals("2")) {
            throw new IllegalArgumentException();
        }
        return userInput;
    }
}
