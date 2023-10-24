package baseball.controller;

import baseball.controller.GameState.State;

public class GameController {

    private GameState gameState;
    private Scoring scoring;

    public GameController() {
        this.gameState = new GameState(State.TERMINATED);
    }

    public void start() {
        this.gameState.changeStateToStartGame();
        this.scoring = new Scoring(RandomNumberCreator.create());
    }

    public GameState getGameState() {
        return this.gameState;
    }

    public Scoring getScoring() {
        return this.scoring;
    }
}
