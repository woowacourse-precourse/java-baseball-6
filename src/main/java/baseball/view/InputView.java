package baseball.view;
public class InputView {

    private final String INPUT_NUM_MESSAGE = "숫자를 입력해주세요 : ";
    private final String RESET_GAME_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public void printInputMessage() {
        System.out.print(INPUT_NUM_MESSAGE);
    }

    public void printRestartOrEnd() {
        System.out.println(RESET_GAME_MESSAGE);
    }

}
