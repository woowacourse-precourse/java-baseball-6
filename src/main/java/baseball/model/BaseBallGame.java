package baseball.model;

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
        if (gameInput.equals("2")) {
            BaseBallGame.isRunning = false;
        } else if (gameInput.equals("1")) {
            BaseBallGame.isRunning = true;
        }
    }

    private boolean isStrike(Map<String, Integer> gameResult) {
        boolean isStrike = false;
        if (gameResult.containsKey("스트라이크")) {
            int strikeCount = gameResult.get("스트라이크");
            if (strikeCount == 3) {
                isStrike = true;
            }
        }
        return isStrike;
    }
}