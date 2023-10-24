package baseball.controller;

import baseball.controller.GameState.State;
import java.util.Map;

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
    public Map<String, Integer> checkAnswer(String userInputAnswer) {
        Map<String, Integer> scoreResult = scoring.score(userInputAnswer);
        // TODO 상태 변경

        return scoreResult;
    }

    public GameState getGameState() {
        return this.gameState;
    }

    public Scoring getScoring() {
        return this.scoring;
    }
}
