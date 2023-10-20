package baseball;

public class Result {
    private final int strike;
    private final int ball;

    public Result(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public void print() {
        String message = "";
        if (strike == 0 && ball == 0) {
            message += "낫싱";
        }
        if(ball > 0) {
            message += ball + "볼";
        }
        if (strike > 0) {
            if (!message.isEmpty()) {
                message += " ";
            }
            message += strike + "스트라이크";
        }

        System.out.println(message);
    }

    public boolean isCorrect(int answerLength) {
        return strike == answerLength;
    }
}