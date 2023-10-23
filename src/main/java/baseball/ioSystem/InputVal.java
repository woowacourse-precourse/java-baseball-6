package baseball.ioSystem;

import camp.nextstep.edu.missionutils.Console;



public class InputVal {
    public static String setPlayerNumber() {
        System.out.println("숫자를 입력해 주세요:");
        return Console.readLine();
    }

    public static String endGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return Console.readLine();
    }
}
