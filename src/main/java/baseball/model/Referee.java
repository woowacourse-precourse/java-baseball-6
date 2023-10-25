package baseball.model;

import baseball.model.number.PlayNumber;
import baseball.model.rule.GameRule;

public class Referee {

    private Referee() {
    }

    public static int answerResult(final GameRule gameRule, final PlayNumber computer, final PlayNumber user) {
        return gameRule.calculate(computer.getNumber(), user.getNumber());
    }
}
