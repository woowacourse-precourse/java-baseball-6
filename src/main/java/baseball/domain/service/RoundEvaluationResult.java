package baseball.domain.service;

import baseball.domain.model.GameStatus;
import java.security.PublicKey;
import java.util.Objects;

public class RoundEvaluationResult {
    private GameStatus gameStatus;
    private final String evaluationMessage;
    private final String EXIT_GAMENUMBER = "2";

    public RoundEvaluationResult(GameStatus gameStatus, String evaluationMessage) {
        this.gameStatus = gameStatus;
        this.evaluationMessage = evaluationMessage;
    }

    public String getEvaluationMessage() {
        return evaluationMessage;
    }

    public boolean isgameOver() {
        return gameStatus == GameStatus.GAME_OVER;
    }

    public boolean isExit() {
        return gameStatus != GameStatus.EXIT;
    }

    public void eveluateRestart(String readRestartResponseInput) {
        if (Objects.equals(readRestartResponseInput, EXIT_GAMENUMBER)) {
            gameStatus = GameStatus.EXIT;
        }
    }
}

