package baseball.baseball;

import baseball.game.turn.TurnBasedGameService;
import baseball.game.turn.TurnInput;
import baseball.game.turn.TurnResult;

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
    public TurnResult playTurn(TurnInput turnInput) {
        BaseballGameTurnInput baseballGameTurnInput = (BaseballGameTurnInput) turnInput;
        return baseballGameTurnInput.calculateResult(answer);
    }
}
