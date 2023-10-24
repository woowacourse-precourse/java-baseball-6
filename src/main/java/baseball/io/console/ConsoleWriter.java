package baseball.io.console;

public class ConsoleWriter {

    private static final String GAME_START_TEXT = "숫자 야구 게임을 시작합니다.";
    public static final String NUMBER_INPUT_TEXT = "숫자를 입력해주세요 : ";
    public static final String CONGRATULATION_TEXT = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public static final String REPLAY_ASK_TEXT = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public void printGameStartText() {
        printLine(GAME_START_TEXT);
    }

    public void printNumberInputText() {
        print(NUMBER_INPUT_TEXT);
    }

    public void printCongratulationText() {
        printLine(CONGRATULATION_TEXT);
    }

    public void printReplayAskText() {
        printLine(REPLAY_ASK_TEXT);
    }

    public void printLine(String source) {
        System.out.println(source);
    }

    private void print(String source) {
        System.out.print(source);
    }

}
