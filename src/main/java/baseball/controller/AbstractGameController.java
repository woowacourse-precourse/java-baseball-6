package baseball.controller;

import baseball.state.GameState;
import baseball.state.Scoring;
import java.util.Map;

public abstract class AbstractGameController implements GameController {
    private final GameState gameState;
    private final Scoring scoring;

    public AbstractGameController(Scoring scoring) {
        this.gameState = new GameState(GameState.getStateForRestart());
        this.scoring = scoring;
    }

    @Override
    public void start() {
        this.gameState.changeStateToStartGame();
    }

    @Override
    public Map<String, Integer> checkAnswer(String userInputAnswer) {
        Map<String, Integer> scoreResult = scoring.score(userInputAnswer);

        if (isCorrect(scoreResult)) {
            gameState.changeStateToTerminateGame();
        }
        return scoreResult;
    }

    private static boolean isCorrect(Map<String, Integer> scoreResult) {
        return scoreResult.getOrDefault("스트라이크", 0) == 3;
    }

    @Override
    public boolean isAbleToRestart() {
        return gameState.isTerminated();
    }

    @Override
    public boolean isAbleToTerminate() {
        return gameState.isTerminated();
    }

    public GameState getGameState() {
        return this.gameState;
    }

    public Scoring getScoring() {
        return this.scoring;
    }
}
