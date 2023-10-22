package baseball;

public class Result {
    final String STRING_BALL = "볼 ";
    final String STRING_STRIKE = "스트라이크 ";
    final String STRING_NOTHING = "낫싱";

    int strike;
    int ball;
    int nothing;

    public Result(int strike, int ball, int nothing) {
        this.strike = strike;
        this.ball = ball;
        this.nothing = nothing;
    }

    void print() {
        System.out.println(stringBuild());
    }

    private String stringBuild() {
        StringBuilder stringBuilder = new StringBuilder();
        if (nothing == 3) {
            stringBuilder.append(STRING_NOTHING);
            return stringBuilder.toString();
        }
        if (ball > 0) {
            stringBuilder.append(ball);
            stringBuilder.append(STRING_BALL);
        }
        if (strike > 0) {
            stringBuilder.append(strike);
            stringBuilder.append(STRING_STRIKE);
        }
        return stringBuilder.toString();
    }

    boolean isMatched() {
        return (strike == 3);
    }
}
