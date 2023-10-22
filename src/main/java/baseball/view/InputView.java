package baseball.view;

public class InputView {

    private static final String REQUEST_RESTART_OR_EXIT_MSG = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String REQUEST_NUMBER_MSG = "숫자를 입력해주세요 : ";

    public void printSuggestNumberMessage() {
        System.out.print(REQUEST_NUMBER_MSG);
    }

    public void printRestartOrExitMessage() {
        System.out.println(REQUEST_RESTART_OR_EXIT_MSG);
    }
}
