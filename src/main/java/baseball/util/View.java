package baseball.util;

import camp.nextstep.edu.missionutils.Console;

public class View {

    private static final String START_MESSAGE = "숫자야구를 시작합니다.";
    private static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String ALL_STRIKE_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String RETRY_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public static void printStartMessage() {
        System.out.println(START_MESSAGE);
    }

    public static String input() {
        System.out.print(INPUT_MESSAGE);
        return Console.readLine();
    }

    public static String retry() {
        System.out.println(ALL_STRIKE_MESSAGE + "\n" + RETRY_MESSAGE);
        return Console.readLine();
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }

}
