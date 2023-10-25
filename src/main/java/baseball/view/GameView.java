package baseball.view;

public class GameView {

    private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String GAME_SUCCESS_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String GAME_OPTION_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";

    public void printStartGameMessage() {
        System.out.println(GAME_START_MESSAGE);
    }

    public void printSuccessGameMessage() {
        System.out.println(GAME_SUCCESS_MESSAGE);
        printOptionMessage();
    }

    private void printOptionMessage() {
        System.out.println(GAME_OPTION_MESSAGE);
    }

    public void printInputNumberMessage() {
        System.out.print(INPUT_NUMBER_MESSAGE);
    }

    public void printAnswerHintMessage(String hint) {
        System.out.println(hint);
    }

}

