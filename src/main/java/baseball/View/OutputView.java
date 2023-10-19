package baseball.View;

public class OutputView {
    private static final String START_GAME_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String END_GAME_MESSAGE = "게임 종료";

    public static void printStartGameMessage() {
        System.out.println(START_GAME_MESSAGE);
    }
    public static void printEndGameMessage() {
        System.out.println(END_GAME_MESSAGE);
    }
}
