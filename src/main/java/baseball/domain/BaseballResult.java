package baseball.domain;

import java.util.ArrayList;
import java.util.List;

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
        List<String> results = new ArrayList<>();
        if (strikeResult != Strike.ZERO) {
            results.add(strikeResult.toString());
        }
        if (ballResult != Ball.ZERO) {
            results.add(ballResult.toString());
        }
        return String.join(" ", results);
    }


}