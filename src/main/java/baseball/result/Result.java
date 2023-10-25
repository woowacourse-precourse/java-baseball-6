package baseball.result;

public class Result {
    private Status strike;
    private Status ball;
    private static final int MAX_COUNT = 3;
    private static final int MIN_COUNT = 0;

    public Result(Status ball, Status strike) {
        this.strike = strike;
        this.ball = ball;
    }

    public void checkResult() {
        if (strike.count() == MIN_COUNT && ball.count() == MIN_COUNT) {
            System.out.print("낫싱");
        }
        printResult();
    }

    public void printResult() {
        printBall();
        printStrike();
        System.out.println();
    }

    private void printBall() {
        if (ball.count() != MIN_COUNT) {
            System.out.print(ball.count() + "볼 ");
        }
    }

    private void printStrike() {
        if (strike.count() != MIN_COUNT) {
            System.out.print(strike.count() + "스트라이크");
        }
    }

    public boolean isWin() {
        return strike.count() == MAX_COUNT;
    }

    public void printWin() {
        System.out.println(MAX_COUNT + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
