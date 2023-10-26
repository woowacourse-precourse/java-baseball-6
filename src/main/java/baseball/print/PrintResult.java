package baseball.print;

public class PrintResult {

    private static final String STRIKE = "스트라이크";
    private static final String BALL = "볼";
    private static final String NOTHING = "낫싱";
    public void printResult(int strike, int ball) {
        printBall(ball);
        printStrike(strike, ball);
        printNothing(strike, ball);
        System.out.println();
    }

    private void printStrike(int strike, int ball) {
        if (ball > 0 && strike > 0) {
            System.out.print(" ");
        }
        if (strike > 0) {
            System.out.print(strike + STRIKE);
        }
    }

    private void printBall (int ball) {
        if (ball > 0) {
            System.out.print(ball + BALL);
        }
    }

    private void printNothing (int strike, int ball) {
        if (strike == 0 && ball == 0) {
            System.out.print(NOTHING);
        }
    }
}
