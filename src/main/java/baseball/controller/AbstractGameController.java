package baseball.controller;

import baseball.controller.GameState.State;

public abstract class AbstractGameController implements GameController {
    private final GameState gameState;
    private Scoring scoring;

    public AbstractGameController() {
        this.gameState = new GameState(State.TERMINATED);
    }

    @Override
    public void start() {
        this.gameState.changeStateToStartGame();
        this.scoring = new Scoring(RandomNumberCreator.create(3));
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
