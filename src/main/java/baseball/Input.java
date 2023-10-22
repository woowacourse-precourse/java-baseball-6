package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    public static String getUserInput() {
        System.out.print("숫자를 입력해주세요 : ");
        return Console.readLine();
    }

    public static boolean isNewGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String userInput = Console.readLine();
        if (userInput.equals("1")) {
            return true;
        }
        return false;
    }
}
