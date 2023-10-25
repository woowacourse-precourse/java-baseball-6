package baseball.evaluator;

public class BallStrike implements EvalResult {
    private int ball;
    private int strike;

    public BallStrike(int ball, int strike) {
        this.ball = ball;
        this.strike = strike;
    }

    @Override
    public void printResult() {
        if (ball == 0 && strike == 0) {
            System.out.println("낫싱");
        } else {
            if (ball != 0) {
                System.out.print(String.format("%d 볼 ", ball));
            }
            if (strike != 0) {
                System.out.println(String.format("%d 스트라이크", strike));
            }
        }
    }

    @Override
    public boolean isClear(int answerLength) {
        if (strike == answerLength) {
            return true;
        }
        return false;
    }
}
