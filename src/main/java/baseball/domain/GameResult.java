package baseball.domain;

import baseball.view.OutputFormat;
import java.util.EnumMap;
import java.util.Map;

public class GameResult {

    private static final int INITIAL_VALUE = 0;
    private static final int ADDING_VALUE = 1;
    private static final int OUT_CRITERION = 3;
    private final Map<Judgement, Integer> result = new EnumMap<>(Judgement.class);

    public GameResult() {
        result.put(Judgement.BALL, INITIAL_VALUE);
        result.put(Judgement.STRIKE, INITIAL_VALUE);
        result.put(Judgement.OUT, INITIAL_VALUE);
    }

    public void updateScore(Judgement judgement) {
        result.put(judgement, result.get(judgement) + ADDING_VALUE);
    }

    public boolean isThreeStrike() {
        return result.get(Judgement.STRIKE) == OUT_CRITERION;
    }

    @Override
    public String toString() {
        int strikeCount = result.get(Judgement.STRIKE);
        int ballCount = result.get(Judgement.BALL);
        int outCount = result.get(Judgement.OUT);

        return OutputFormat.getFormat(strikeCount, ballCount, outCount);
    }
}