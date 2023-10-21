package baseball.model;

public class Referee {

    private static final int DEFAULT_NUMBER = 0;

    private int hitter;
    private int pitcher;

    private Referee(final int hitter, final int pitcher) {
        this.hitter = hitter;
        this.pitcher = pitcher;
    }

    public static Referee createDefault() {
        return new Referee(DEFAULT_NUMBER, DEFAULT_NUMBER);
    }

    public int answerResult(final GameRule gameRule) {
        return gameRule.calculate(pitcher, hitter);
    }

    public void prepareJudgement(final int hitter, final int pitcher) {
        this.hitter = hitter;
        this.pitcher = pitcher;
    }

    public void resetGame() {
        this.hitter = DEFAULT_NUMBER;
        this.pitcher = DEFAULT_NUMBER;
    }
}
