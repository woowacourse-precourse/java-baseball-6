package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class Message {
    private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String WIN_MESSAGE = "개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String NOTHING_MESSAGE = "낫싱";
    private static final String BALL_MESSAGE = "볼";
    private static final String STRIKE_MESSAGE = "스트라이크";
    private static final String SPACE = " ";
    public static final String CONTINUE_GAME = "1";
    private static final String EXIT_GAME = "2";
    private static final String CONTINUE_EXIT_MESSAGE
            = "게임을 새로 시작하려면 " + CONTINUE_GAME
            + ", 종료하려면 " + EXIT_GAME + "를 입력하세요.";

    public static void startMessage() {
        System.out.println(START_MESSAGE);
    }

    public static String readInput() {
        return Console.readLine();
    }

    public static void inputMessage() {
        System.out.print(INPUT_MESSAGE);
    }

    public static void nothingMessage() {
        System.out.println(NOTHING_MESSAGE);
    }

    public static void ballMessage(int ball) {
        System.out.print(ball);
        System.out.print(BALL_MESSAGE);
    }

    public static void strikeMessage(int strike) {
        System.out.print(strike);
        System.out.print(STRIKE_MESSAGE);
    }

    public static void printSpace() {
        System.out.print(SPACE);
    }

    public static void printLinebreak() {
        System.out.println();
    }

    public static void winMessage(int numberLength) {
        System.out.print(numberLength);
        System.out.println(WIN_MESSAGE);
    }

    public static void continueExitMessage() {
        System.out.println(CONTINUE_EXIT_MESSAGE);
    }
}
