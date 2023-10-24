package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleView {
    private static final String GAME_START_OUTPUT_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String GAME_FINISH_OUTPUT_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String THREE_DIGIT_NUMBER_INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String GAME_PROGRESS_NUMBER_INPUT_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String STRIKE_MESSAGE = "스트라이크";
    private static final String BALL_MESSAGE = "볼";
    private static final String NOTHING_MESSAGE = "낫싱";

    public static void printGameStart() {
        System.out.println(GAME_START_OUTPUT_MESSAGE);
    }

    public static String inputThreeDigitNumber() {
        System.out.print(THREE_DIGIT_NUMBER_INPUT_MESSAGE);
        return Console.readLine();
    }

    public static void printStrikeCount(int count) {
        System.out.println(count + STRIKE_MESSAGE);
    }

    public static void printBallCount(int count) {
        System.out.println(count + BALL_MESSAGE);
    }

    public static void printBallAndStrikeCount(int ball, int strike) {
        System.out.println(ball + BALL_MESSAGE + " " + strike + STRIKE_MESSAGE);
    }

    public static void printNothing() {
        System.out.println(NOTHING_MESSAGE);
    }

    public static void printGameFinsh() {
        System.out.println(GAME_FINISH_OUTPUT_MESSAGE);
    }

    public static String inputGameProgressNumber() {
        System.out.print(GAME_PROGRESS_NUMBER_INPUT_MESSAGE);
        return Console.readLine();
    }
}
