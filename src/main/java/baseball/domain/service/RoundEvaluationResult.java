package baseball.domain.service;

import baseball.domain.model.GameStatus;

public class RoundEvaluationResult {
    private GameStatus gameStatus;
    private final String evaluationMessage;

    public RoundEvaluationResult(GameStatus gameStatus, String evaluationMessage) {
        this.gameStatus = gameStatus;
        this.evaluationMessage = evaluationMessage;
    }

    public String getEvaluationMessage() {
        return evaluationMessage;
    }

    public boolean isGameOver() {
        return gameStatus == GameStatus.GAME_OVER;
    }

    public boolean isExit() {
        return gameStatus == GameStatus.EXIT;
    }

    public void eveluateRestart(String readRestartResponseInput) {
        gameStatus = GameStatus.of(readRestartResponseInput);
    }
}

