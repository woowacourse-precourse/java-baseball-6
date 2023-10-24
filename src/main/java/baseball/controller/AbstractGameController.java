package baseball.controller;

import baseball.controller.GameState.State;
import java.util.Map;

public abstract class AbstractGameController implements GameController {
    private final GameState gameState;
    private Scoring scoring;

    public AbstractGameController(Scoring scoring) {
        this.gameState = new GameState(State.TERMINATED);
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
        return scoreResult.getOrDefault("홈런", 0) == 3;
    }

    public GameState getGameState() {
        return this.gameState;
    }

    public Scoring getScoring() {
        return this.scoring;
    }
}
