package baseball.controller;

import baseball.state.ScoringFactory;

public interface GameControllerFactory {

    GameController get(ScoringFactory scoringFactory);
}
