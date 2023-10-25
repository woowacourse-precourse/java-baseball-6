package baseball.model;

import baseball.controller.GameUtils;
import java.util.*;

public class GameManager {
    private GameCompetitor counterPlayer;
    private List<Integer> computerNumber;
    private GameUtils utility;

    public GameManager() {
        this.counterPlayer = new GameCompetitor();
        this.computerNumber = this.counterPlayer.generateRandomNumber();
        this.utility = new GameUtils();
    }

    public GameStatusCode processTurn(String playerNumber) {
        if (utility.isValidInputForm(playerNumber)) {
            List<Integer> gameTurnResult = GameUtils.compareNumbers(playerNumber, computerNumber);

            GameUtils.printGameTurnResult(gameTurnResult);
            System.out.println();
            if (GameUtils.isGameOver(gameTurnResult)) {
                return GameStatusCode.STOP;
            }
        } else {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
        return GameStatusCode.PLAYING;
    }
}
