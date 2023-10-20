package baseball;

public class StepResult {
    private final int numOfBall;
    private final int numOfStrike;

    public StepResult(int numOfBall, int numOfStrike) {
        this.numOfBall = numOfBall;
        this.numOfStrike = numOfStrike;
    }

    public int getNumOfBall() {
        return this.numOfBall;
    }

    public int getNumOfStrike() {
        return this.numOfStrike;
    }

    @Override
    public String toString() {
        boolean zBall = this.numOfBall != 0;
        boolean zStrike = this.numOfStrike != 0;
        if (!zBall && !zStrike) {
            return "낫싱";
        }
        return (zBall ? this.numOfBall + "볼" : "")
                + ((zBall) && (zStrike) ? " " : "")
                + (zStrike ? this.numOfStrike + "스트라이크" : "");
    }
}
