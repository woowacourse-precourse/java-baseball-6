package baseball.controller;

import baseball.state.ScoringFactory;

public class DefaultGameControllerFactory implements GameControllerFactory {
    @Override
    public GameController get(ScoringFactory scoringFactory) {
        return new GameControllerImpl(scoringFactory);
    }
}
