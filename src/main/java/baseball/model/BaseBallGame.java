package baseball.model;

import baseball.GameMessage;

import java.util.Map;

public class BaseBallGame {
    private static boolean isRunning;

    public BaseBallGame() {
        isRunning = true;
    }

    public static boolean isRunning() {
        return isRunning;
    }

    public void setRunning(Map<String, Integer> gameResult) {
        if (isStrike(gameResult)) {
            BaseBallGame.isRunning = false;
        }
    }

    public void setRunning(String gameInput) {
        if (gameInput.equals(GameMessage.QUIT.getMessage())) {
            BaseBallGame.isRunning = false;
        } else if (gameInput.equals(GameMessage.NEW_GAME.getMessage())) {
            BaseBallGame.isRunning = true;
        }
    }

    private boolean isStrike(Map<String, Integer> gameResult) {
        boolean isStrike = false;
        if (gameResult.containsKey(GameMessage.STRIKE.getMessage())) {
            Integer strikeCount = gameResult.get(GameMessage.STRIKE.getMessage());
            if (strikeCount == GameMessage.STRIKE_COUNT.getNumber()) {
                isStrike = true;
            }
        }
        return isStrike;
    }
}