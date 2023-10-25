package baseball.controller;

import baseball.state.ScoringFactory;

public class GameControllerImpl extends AbstractGameController {

    public GameControllerImpl(ScoringFactory scoringFactory) {
        super(scoringFactory.get());
    }

    @Override
    public boolean isStillWrong() {
        return super.getGameState().isPlaying();
    }
}
