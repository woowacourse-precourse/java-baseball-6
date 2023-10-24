package baseball.controller;

public class GameControllerImpl extends AbstractGameController {

    public GameControllerImpl(Scoring scoring) {
        super(scoring);
    }

    @Override
    public boolean isStillWrong() {
        return super.getGameState().isPlaying();
    }
}
