package baseball.service;

import baseball.model.BaseballType;
import baseball.model.GameResult;

import java.util.List;

import static baseball.model.BaseballType.*;

public class BaseballService {
    public GameResult getGameResult(List<Integer> baseballNumbers, List<Integer> inputNumbers) {
        int ball = 0, strike = 0;
        for (int i = 0; i < inputNumbers.size(); i++) {
            BaseballType baseballType = getBaseballType(baseballNumbers, inputNumbers.get(i), i);
            if (baseballType.equals(BALL)) ball++;
            if (baseballType.equals(STRIKE)) strike++;
        }
        return new GameResult(ball, strike);
    }

    public BaseballType getBaseballType(List<Integer> baseballNumbers, int inputNumber, int inputIndex) {
        for (int i = 0; i < baseballNumbers.size(); i++) {
            if (baseballNumbers.get(i) != inputNumber) continue;
            if (i == inputIndex) return STRIKE;
            return BALL;
        }
        return NOTHING;
    }

    public boolean isFinished(GameResult gameResult) {
        if (gameResult.getStrike() == 3) return true;
        return false;
    }
}
