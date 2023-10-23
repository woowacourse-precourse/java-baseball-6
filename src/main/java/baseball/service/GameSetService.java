package baseball.service;

import baseball.domain.GameSet;
import baseball.domain.RoundResult;
import baseball.domain.gamenumber.GameNumbers;

public class GameSetService {
    private final GameSet gameSet;

    public GameSetService(GameSet gameSet) {
        this.gameSet = gameSet;
    }

    public RoundResult playRound(String userNumberInput) {
        GameNumbers userGameNumbers = new GameNumbers(userNumberInput);
        return gameSet.playRound(userGameNumbers);
    }

    public boolean isSetEnd() {
        return gameSet.isSetEnd();
    }
}
