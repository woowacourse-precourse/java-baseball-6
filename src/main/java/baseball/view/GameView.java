package baseball.view;

import baseball.constant.GameMessage;
import baseball.model.GameResult;

public class GameView {

    public void printGameStartMessage() {
        System.out.println(GameMessage.GAME_START);
    }

    public void printInputGameDecisionMessage() {
        System.out.println(GameMessage.INPUT_GAMEDECISION);
    }

    public void printNumberInputMessage() {
        System.out.print(GameMessage.NUMBER_INPUT);
    }

    public void printGameEndMessage() {
        System.out.println(GameMessage.GAME_END);
    }

    public void printResultMessage(GameResult result) {
        System.out.println(result.toString());
    }
}
