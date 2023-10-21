package baseball.console;

public class OutputManager {

    private static final String GAME_START_TEXT = "숫자 야구 게임을 시작합니다.";

    private void printLine(String source) {
        System.out.println(source);
    }

    public void printGameStartText() {
        printLine(GAME_START_TEXT);
    }

}
