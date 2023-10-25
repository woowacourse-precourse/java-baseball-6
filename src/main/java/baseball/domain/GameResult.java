package baseball.domain;

import baseball.view.OutputFormat;
import java.util.EnumMap;
import java.util.Map;

public class GameResult {

    private final Map<Judgement, Integer> result = new EnumMap<>(Judgement.class);

    public GameResult() {
        result.put(Judgement.BALL, 0);
        result.put(Judgement.STRIKE, 0);
        result.put(Judgement.OUT, 0);
    }

    public void updateScore(Judgement judgement) {
        result.put(judgement, result.get(judgement) + 1);
    }

    public boolean isThreeStrike() {
        return result.get(Judgement.STRIKE) == 3;
    }

    @Override
    public String toString() {
        int strikeCount = result.get(Judgement.STRIKE);
        int ballCount = result.get(Judgement.BALL);
        int outCount = result.get(Judgement.OUT);

        return OutputFormat.getFormat(strikeCount, ballCount, outCount);
    }
}