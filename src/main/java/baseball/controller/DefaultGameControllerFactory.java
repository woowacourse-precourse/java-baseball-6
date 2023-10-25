package baseball.controller;

import baseball.state.Scoring;
import baseball.util.DefaultRandomNumberCreatorByDigit;

public class DefaultGameControllerFactory implements GameControllerFactory {
    @Override
    public GameController get() {
        return new GameControllerImpl(new Scoring(new DefaultRandomNumberCreatorByDigit().create(3)));
    }
}
