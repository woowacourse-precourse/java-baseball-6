package baseball;

public class Hint {

    private int strike;
    private int ball;

    public Hint() {
        this.strike = 0;
        this.ball = 0;
    }

    @Override
    public String toString() {
        if (ball == 0 && strike == 0) {
            return "낫싱";
        } else if (ball == 0 && strike > 0) {
            return strike + "스트라이크";
        } else if (ball > 0 && strike == 0) {
            return ball + "볼";
        } else if (ball > 0 && strike > 0) {
            return ball + "볼 " + strike + "스트라이크";
        } else {
            throw new RuntimeException("볼과 스트라이크가 음수입니다.");
        }
    }

    public void increaseBall() {
        ball++;
    }

    public void increaseStrike() {
        strike++;
    }

    public boolean isAnswer() {
        return strike == 3 && ball == 0;
    }

}