package baseball.View;

public class OutputView {
    private static final String START_GAME_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String END_GAME_MESSAGE = "게임 종료";
    private static final String SUCCESS_MESSAGE = "3개의 숫자를 모두 맞히셨습니다!";

    public static void printStartGameMessage() {
        System.out.println(START_GAME_MESSAGE);
    }
    public static void printEndGameMessage() {
        System.out.print(END_GAME_MESSAGE);
    }

    public static void printSuccessMessage() {
        System.out.println(SUCCESS_MESSAGE);
    }
}
