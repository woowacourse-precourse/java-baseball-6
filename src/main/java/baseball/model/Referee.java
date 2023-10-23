package baseball.model;

public class Referee {

    public static int answerResult(final GameRule gameRule, final PlayNumber computer, final PlayNumber user) {
        return gameRule.calculate(computer.getNumber(), user.getNumber());
    }
}
