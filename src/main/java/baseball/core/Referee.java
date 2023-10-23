package baseball.core;

import baseball.dto.GameResult;

import java.util.List;

public class Referee {

    private final GameRule gameRule;

    public Referee(GameRule gameRule) {
        this.gameRule = gameRule;
    }

    public GameResult judge(List<Integer> computerNumbers, List<Integer> userNumbers) {
        return gameRule.apply(computerNumbers, userNumbers);
    }
}
