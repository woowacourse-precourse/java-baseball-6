package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class RestartView {

    private static final String RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public static void print() {
        System.out.println(RESTART_MESSAGE);
    }

    public static boolean doRestart() {
        final String input = Console.readLine().trim();
        return input.equals("1");
    }

}
