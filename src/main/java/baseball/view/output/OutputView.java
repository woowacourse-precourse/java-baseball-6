package baseball.view.output;

public class OutputView {

    private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";

    public void printStartGame() {
        println(GAME_START_MESSAGE);
    }

    private void println(String message) {
        System.out.println(message);
    }
}
