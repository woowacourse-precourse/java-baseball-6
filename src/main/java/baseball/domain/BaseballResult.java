package baseball.domain;

public class BaseballResult {
    private final Strike strikeResult;
    private final Ball ballResult;

    public BaseballResult(Strike strikeResult, Ball ballResult) {
        this.strikeResult = strikeResult;
        this.ballResult = ballResult;
    }

    @Override
    public String toString() {
        if (isNoting()) {
            return "낫싱";
        }
        return formatResult();
    }

    private boolean isNoting() {
        return strikeResult == Strike.ZERO && ballResult == Ball.ZERO;
    }

    private String formatResult() {
        StringBuilder result = new StringBuilder();

        if (strikeResult != Strike.ZERO) {
            result.append(strikeResult);
        }

        if (ballResult != Ball.ZERO) {
            if (result.length() > 0) {
                result.append(" ");
            }
            result.append(ballResult);
        }

        return result.toString();
    }

}