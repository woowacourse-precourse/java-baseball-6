package baseball;

public class Result implements Rule {
    final String STRING_BALL = "볼";
    final String STRING_STRIKE = "스트라이크";
    final String STRING_NOTHING = "낫싱";
    final String STRING_SPACE = " ";

    int strike;
    int ball;
    int nothing;

    public Result(int strike, int ball, int nothing) {
        this.strike = strike;
        this.ball = ball;
        this.nothing = nothing;
    }

    void print() {
        System.out.println(message());
    }

    String message() {
        if (nothing == DIGIT_SIZE) {
            return STRING_NOTHING;
        }
        StringBuilder stringBuilder = new StringBuilder();
        if (ball > 0) {
            stringBuilder.append(ball);
            stringBuilder.append(STRING_BALL);
        }
        if (ball > 0 && strike > 0) {
            stringBuilder.append(STRING_SPACE);
        }
        if (strike > 0) {
            stringBuilder.append(strike);
            stringBuilder.append(STRING_STRIKE);
        }
        return stringBuilder.toString();
    }

    boolean isMatched() {
        return (strike == DIGIT_SIZE);
    }
}
