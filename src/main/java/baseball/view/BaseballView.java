package baseball.view;

import baseball.domain.BallAndStrike;

public class BaseballView {
    // TODO: 야구 게임 화면 출력
    private final static String GAME_START = "숫자 야구 게임을 시작합니다.";
    private final static String GAME_END = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private final static String USER_INPUT = "숫자를 입력해주세요 : ";
    private final static String GAME_EXIT = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public static void printGameStart() {
        printView(GAME_START);
    }

    public static void printGameEnd() {
        printView(GAME_END);
    }

    public static void requestUserInput() {
        printView(USER_INPUT);
    }

    public static void printGuessValue(BallAndStrike ballAndStrike) {
        printView(ballAndStrike.toString());
    }

    public static void requestGameExit() {
        printView(GAME_EXIT);
    }

    private static void printView(String view) {
        System.out.println(view);
    }

}
