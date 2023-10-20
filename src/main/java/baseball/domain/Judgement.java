package baseball.domain;

public class Judgement {
    private int numOfBall;
    private int numOfStrike;

    public Judgement(int numOfBall, int numOfStrike) {
        this.numOfBall = numOfBall;
        this.numOfStrike = numOfStrike;
    }

    public boolean isThreeStrike() {
        return numOfStrike == 3;
    }

    public boolean isNothing() {
        return numOfBall == 0 && numOfStrike == 0;
    }

    public void sayBallAndStrike() {
        String message = "";
        if (numOfBall == 0 && numOfStrike > 0) {
            message = String.format("%d스트라이크", numOfStrike);
        } else if (numOfBall > 0 && numOfStrike == 0) {
            message = String.format("%d볼", numOfBall);
        } else {
            message = String.format("%d볼 %d스트라이크", numOfBall, numOfStrike);
        }
        System.out.println(message);
    }
}
