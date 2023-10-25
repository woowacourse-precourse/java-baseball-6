package baseball;

import java.util.ArrayList;
import java.util.HashMap;

public class BaseballResult {
    public enum BaseballResultType {
        STRIKE, BALL, OUT
    }

    private final HashMap<BaseballResultType, Integer> _baseballResult;
    private final int ballCount;

    public BaseballResult(int answerLength) {
        this.ballCount = answerLength;
        _baseballResult = new HashMap<>();
        initializeBaseballResult();
    }

    public String toString() {
        if (_baseballResult.get(BaseballResultType.OUT) == ballCount) {
            return "낫싱";
        }

        ArrayList<String> result = new ArrayList<>();
        if (_baseballResult.get(BaseballResultType.BALL) > 0) {
            result.add(String.format("%d볼", _baseballResult.get(BaseballResultType.BALL)));
        }
        if (_baseballResult.get(BaseballResultType.STRIKE) > 0) {
            result.add(String.format("%d스트라이크", _baseballResult.get(BaseballResultType.STRIKE)));
        }

        return String.join(" ", result);
    }

    public void initializeBaseballResult() {
        _baseballResult.put(BaseballResultType.STRIKE, 0);
        _baseballResult.put(BaseballResultType.BALL, 0);
        _baseballResult.put(BaseballResultType.OUT, 0);
    }

    public void strike() {
        _baseballResult.put(BaseballResultType.STRIKE, _baseballResult.get(BaseballResultType.STRIKE) + 1);
    }

    public void ball() {
        _baseballResult.put(BaseballResultType.BALL, _baseballResult.get(BaseballResultType.BALL) + 1);
    }

    public void out() {
        _baseballResult.put(BaseballResultType.OUT, _baseballResult.get(BaseballResultType.OUT) + 1);
    }

    public int strikeCount() {
        return _baseballResult.get(BaseballResultType.STRIKE);
    }
}
