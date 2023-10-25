package baseball;

public class BaseballDisplay {
    private final String START_GAME_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private final String BASEBALL_NUMBER_INPUT_REQUEST_MESSAGE = "숫자를 입력해주세요 : ";
    private final String ALL_STRIKE_AND_ROUND_OVER_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private final String GAME_OVER_MESSAGE = "게임 종료";
    private final String CONTINUE_GAME_INPUT_REQUEST_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public void startGame() {
        displayMessage(START_GAME_MESSAGE);
    }

    public void baseballNumberInputRequest() {
        displayMessage(BASEBALL_NUMBER_INPUT_REQUEST_MESSAGE);
    }

    public void allStrikeAndRoundOver() {
        displayMessage(ALL_STRIKE_AND_ROUND_OVER_MESSAGE);
    }

    public void gameOver() {
        displayMessage(GAME_OVER_MESSAGE);
    }

    public void continueGameInputRequest() {
        displayMessage(CONTINUE_GAME_INPUT_REQUEST_MESSAGE);
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }
}
