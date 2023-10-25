package baseball.view;

import baseball.constant.GameMessage;
import baseball.model.GameResult;

public class GameView {

    public void printGameStartMessage() {
        System.out.println(GameMessage.GAME_START.getMessage());
    }

    public void printInputGameDecisionMessage() {
        System.out.println(GameMessage.INPUT_GAME_DECISION.getMessage());
    }

    public void printInputNumberMessage() {
        System.out.print(GameMessage.INPUT_NUMBER.getMessage());
    }

    public void printGameEndMessage() {
        System.out.println(GameMessage.GAME_END.getMessage());
    }

    public void printResultMessage(GameResult result) {
        System.out.println(result.toString());
    }
}
