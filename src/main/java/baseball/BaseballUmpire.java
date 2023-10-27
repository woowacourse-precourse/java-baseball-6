package baseball;

import java.util.List;

public class BaseballUmpire {

    private GameRule gameRule;

    public BaseballUmpire(GameRule gameRule) {
        this.gameRule = gameRule;
    }

    public GameStatus getGameStatus(List<Integer> botNumbers, List<Integer> playerNumbers) {
        return gameRule.determineGameStatus(botNumbers, playerNumbers);
    }
}
