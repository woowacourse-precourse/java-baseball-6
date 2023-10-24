package baseball.controller;

import baseball.controller.GameState.State;

public class GameControllerImpl implements GameController {

    private final GameState gameState;
    private Scoring scoring;

    public GameControllerImpl() {
        this.gameState = new GameState(State.TERMINATED);
    }

    @Override
    public void start() {
        this.gameState.changeStateToStartGame();
        this.scoring = new Scoring(RandomNumberCreator.create(3));
    }

    @Override
    public boolean isStillWrong() {
        // TODO
        return false;
    }

    @Override
    public void checkAnswer(String userInputAnswer) {
        // TODO
    }

    public GameState getGameState() {
        return this.gameState;
    }

    public Scoring getScoring() {
        return this.scoring;
    }
}
