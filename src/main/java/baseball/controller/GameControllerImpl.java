package baseball.controller;

import baseball.state.Scoring;

public class GameControllerImpl extends AbstractGameController {

    public GameControllerImpl(Scoring scoring) {
        super(scoring);
    }

    @Override
    public boolean isStillWrong() {
        return super.getGameState().isPlaying();
    }
}
