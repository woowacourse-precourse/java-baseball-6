package baseball.baseball;

import baseball.game.turn.TurnBasedGameService;
import baseball.game.turn.TurnInput;

public class BaseballGameService implements TurnBasedGameService {

    private final BaseballNumberGenerator numberGenerator;
    private BaseballNumber answer;

    public BaseballGameService(BaseballNumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    @Override
    public void init() {
        answer = numberGenerator.generate();
    }

    @Override
    public BaseballGameTurnResult playTurn(TurnInput turnInput) {
        BaseballGameTurnInput baseballGameTurnInput = (BaseballGameTurnInput) turnInput;
        BaseballNumber baseballNumber = baseballGameTurnInput.getBaseballNumber();

        return calculateResult(baseballNumber);
    }

    private BaseballGameTurnResult calculateResult(BaseballNumber baseballNumber) {
        int numBall = answer.countBall(baseballNumber);
        int numStrike = answer.countStrike(baseballNumber);
        return new BaseballGameTurnResult(numStrike == 3, numBall, numStrike);
    }
}
