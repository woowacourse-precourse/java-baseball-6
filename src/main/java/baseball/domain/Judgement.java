package baseball.domain;

public class Judgement {
    private final int numOfBall;
    private final int numOfStrike;

    public Judgement(int numOfBall, int numOfStrike) {
        this.numOfBall = numOfBall;
        this.numOfStrike = numOfStrike;
    }

    public boolean isCorrectAnswer(int numberOfDigitsInAnswer) {
        return numOfStrike == numberOfDigitsInAnswer;
    }

    public void sayBallAndStrike(int numberOfDigitsInAnswer) {
        String message = String.format("%d볼 %d스트라이크", numOfBall, numOfStrike);
        if (numOfBall == 0 && numOfStrike == 0) {
            message = "낫싱";
        } else if (numOfBall == 0 && numOfStrike > 0 && numOfStrike < numberOfDigitsInAnswer) {
            message = String.format("%d스트라이크", numOfStrike);
        } else if (numOfBall > 0 && numOfStrike == 0) {
            message = String.format("%d볼", numOfBall);
        } else if (numOfBall == 0 && numOfStrike == numberOfDigitsInAnswer) {
            message = String.format("%d스트라이크", numberOfDigitsInAnswer);
        }
        System.out.println(message);
    }
}
