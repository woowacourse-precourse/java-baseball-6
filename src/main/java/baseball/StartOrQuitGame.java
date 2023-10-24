package baseball;

import camp.nextstep.edu.missionutils.Console;

public class StartOrQuitGame {

    public static void startOrQuitGame() {

        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        String input = "";

        while (true) {
            input = Console.readLine();
            if ("1".equals(input)) {
                Application.play();
                break;
            } else if ("2".equals(input)) {
                System.out.println("게임을 종료합니다.");
                break;
            }
        }
    }
}
