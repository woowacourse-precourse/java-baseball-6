package baseball.util;

public class Result {
    private Status strike;
    private Status ball;

    public Result(Status ball, Status strike) {
        this.strike = strike;
        this.ball = ball;
    }

    public void checkResult() {
        if (strike.count() == 0 && ball.count() == 0) {
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
        if (ball.count() != 0) {
            System.out.print(ball.count() + "볼 ");
        }
    }

    private void printStrike() {
        if (strike.count() != 0) {
            System.out.print(strike.count() + "스트라이크");
        }
    }

    public boolean isWin() {
        if (strike.count() == 3) {
            return true;
        }
        return false;
    }

    public void printWin() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
