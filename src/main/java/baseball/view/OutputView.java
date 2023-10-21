package baseball.view;

public class OutputView {

    private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String GAME_INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String GAME_FINISHED_MESSAGE = "개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String GAME_RESTART_OR_END_MESSAGE = "게임을 새로 시작하려면 1, 종료하려 2를 입력하세요.";
    private static final int MAX_NUMBER_LENGTH = 3;

    public void printStartMessage() {
        System.out.println(GAME_START_MESSAGE);
    }

    public void printInputNumberMessage() {
        System.out.print(GAME_INPUT_NUMBER_MESSAGE);
    }

    public void printFinishMessage() {
        System.out.println(MAX_NUMBER_LENGTH + GAME_FINISHED_MESSAGE);
    }

    public void printRestartOrEndMessage() {
        System.out.println(GAME_RESTART_OR_END_MESSAGE);
    }
}
