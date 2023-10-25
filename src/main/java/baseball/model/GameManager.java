package baseball.model;

import baseball.controller.GameUtils;
import java.util.*;

public class GameManager {
    private final List<Integer> computerNumber;
    private final GameUtils utility;

    public GameManager() {
        GameCompetitor counterPlayer = new GameCompetitor();
        this.computerNumber = counterPlayer.generateRandomNumber();
        this.utility = new GameUtils();
    }

    public GameStatusCode processTurn(String playerNumber) {
        GameStatusCode result = null;
        if (utility.isValidInputForm(playerNumber)) {
            List<Integer> gameTurnResult = GameUtils.compareNumbers(playerNumber, computerNumber);

            GameUtils.GameTurnResult(gameTurnResult);
            System.out.println();

            if (GameUtils.isGameOver(gameTurnResult)) {
                result = GameStatusCode.STOP;
            }
        } else {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
        if (result == null) {
            result = GameStatusCode.PLAYING;
        }
        return result;
    }
}
