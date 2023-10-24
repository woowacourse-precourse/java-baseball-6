package baseball.view;

import baseball.model.GameMessage;

public class OutputView {

    public void printInputNumberMessage() {
        System.out.println(GameMessage.USER_INPUT_NUMBER_MESSAGE.getMessage());
    }

    public void printStartGameMessage() {
        System.out.println(GameMessage.START_GAME_MESSAGE.getMessage());
    }

    public void printSuccessGameMessage() {
        System.out.println(GameMessage.SUCCESS_GAME_MESSAGE.getMessage());
    }

    public void printRestartGameMessage() {
        System.out.println(GameMessage.RESTART_GAME_MESSAGE.getMessage());
    }

    public void printGameResult(String result) {
        System.out.println(result);
    }
}
