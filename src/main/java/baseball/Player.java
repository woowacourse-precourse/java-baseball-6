package baseball;

import camp.nextstep.edu.missionutils.Console;


public class Player {
    private static final int RESTART = 1;
    private static final int END = 2;

    public static String inputNumbers() {
        System.out.print("숫자를 입력해주세요: ");
        return Console.readLine();
    }

    public static String inputRestartStatus() {
        System.out.println("게임을 새로 시작하려면"+RESTART+", 종료하려면 "+END+"를 입력하세요.");
        return Console.readLine();
    }
}
