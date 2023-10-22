package baseball.io.console;

public class ConsoleWriter {

    private static final String GAME_START_TEXT = "숫자 야구 게임을 시작합니다.";
    public static final String NUMBER_INPUT_TEXT = "숫자를 입력해주세요 : ";

    public void printGameStartText() {
        printLine(GAME_START_TEXT);
    }

    public void printNumberInputText() {
        print(NUMBER_INPUT_TEXT);
    }

    public void printLine(String source) {
        System.out.println(source);
    }

    private void print(String source) {
        System.out.print(source);
    }

}
