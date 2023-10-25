package baseball;

public class BallCounter {

    private int strike;

    private int ball;

    public BallCounter(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public void printResult() {
        StringBuilder messageBuilder = new StringBuilder();

        if (ball > 0) {
            messageBuilder.append(ball).append("볼");
        }

        if (strike > 0) {
            appendSpace(messageBuilder);
            messageBuilder.append(strike).append("스트라이크");
        }

        if (messageBuilder.isEmpty()) {
            messageBuilder.append("낫싱");
        }

        System.out.println(messageBuilder);
    }

    private void appendSpace(StringBuilder messageBuilder) {
        if (ball > 0) {
            messageBuilder.append(" ");
        }
    }


    public boolean isGameOver() {
        if (strike == 3) {
            return true;
        }

        return false;
    }
}
