package baseball;

import camp.nextstep.edu.missionutils.Console;

public class GameConsole {
    public static String UserInput() {
        System.out.print("숫자를 입력해주세요: ");
        return Console.readLine();
    }

    public static void displayMessage(String message) {

        System.out.println(message);
    }

    public static int RestartOrExitChoice() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return Integer.parseInt(Console.readLine());
    }
}

