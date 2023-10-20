package baseball.view;

public class OutputView {
    private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";

    public void printStartMessage() {
        System.out.println(GAME_START_MESSAGE);
    }

    public void printHindMessage(String hintMessage) {
        System.out.println(hintMessage);
    }
}
