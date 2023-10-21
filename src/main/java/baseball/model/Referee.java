package baseball.model;

public class Referee {

    private static final int DEFAULT_NUMBER = 0;

    private int computerNumber;
    private int userNumber;

    private Referee(final int computerNumber, final int userNumber, final boolean flag) {
        this.computerNumber = computerNumber;
        this.userNumber = userNumber;
        this.isEndFlag = flag;
    }

    public static Referee createDefault() {
        return new Referee(DEFAULT_NUMBER, DEFAULT_NUMBER, false);
    }

    public int answerResult(final GameRule gameRule) {
        return gameRule.calculate(userNumber, computerNumber);
    }

    public void prepareJudgement(final int computerNumber, final int userNumber) {
        this.computerNumber = computerNumber;
        this.userNumber = userNumber;
    }

    public void resetGame() {
        this.computerNumber = DEFAULT_NUMBER;
        this.userNumber = DEFAULT_NUMBER;
    }
}
