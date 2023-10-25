package baseball.view;

public class InputView {

    private static final String LINE = "\n";
    private static final String INPUT_BALLS_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String INPUT_GAME_RESTART_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요." + LINE;

    public void printPlayerGuessMessage() {
        displayMessage(INPUT_BALLS_MESSAGE);
    }

    public void printRestartChoiceMessage() {
        displayMessage(INPUT_GAME_RESTART_MESSAGE);
    }

    private void displayMessage(String message) {
        System.out.print(message);
    }
}
