package baseball.view;

public class InputView {

    private static final String INPUT_RESTART_OR_EXIT_MSG = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String INPUT_NUMBER_MSG = "숫자를 입력해주세요 : ";

    public void printGuessNumberInputMessage() {
        System.out.print(INPUT_NUMBER_MSG);
    }

    public void printRestartOrExitInputMessage() {
        System.out.println(INPUT_RESTART_OR_EXIT_MSG);
    }
}
