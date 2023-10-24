package baseball.view;

public class InputView {

    private static final String START_GAME_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String INPUT_GAME_RESTART_OR_STOP = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public void startBaseballGame() {
        System.out.println(START_GAME_MESSAGE);
    }

    public void requestUserInput() {
        System.out.println(INPUT_NUMBER_MESSAGE);
    }

    public void requestGameState() {
        System.out.println(INPUT_GAME_RESTART_OR_STOP);
    }
}
