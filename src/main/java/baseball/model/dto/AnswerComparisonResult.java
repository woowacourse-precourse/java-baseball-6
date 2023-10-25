package baseball.model.dto;

public class AnswerComparisonResult {

    private int numOfBalls;
    private int numOfStrikes;

    public AnswerComparisonResult(int numOfBalls, int numOfStrikes) {
        this.numOfBalls = numOfBalls;
        this.numOfStrikes = numOfStrikes;
    }

    public int getNumOfBalls() {
        return numOfBalls;
    }

    public int getNumOfStrikes() {
        return numOfStrikes;
    }

    public boolean hasThreeStrikes() {
        return numOfStrikes == 3;
    }
}
