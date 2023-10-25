package baseball;

import camp.nextstep.edu.missionutils.Console;

public class InputUI {

    public static boolean restartGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = getUserInput();

        if (!input.equals("1") && !input.equals("2")) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }

        return input.equals("1");
    }

    private static String getUserInput() {
        return Console.readLine();
    }
}
