package baseball.service;

import baseball.domain.GameResult;

public class GameResultService {
    private static final String BALL = "볼";
    private static final String STRIKE = "스트라이크";
    private static final String NOTHING = "낫싱";
    private static final String RESTART = "1";
    private static final String EXIT = "2";

    public String showResult(GameResult gameResult) {
        if (gameResult.isNothing()) {
            return NOTHING;
        }
        else if (gameResult.isOnlyBall()) {
            return gameResult.balls() + BALL;
        }
        else if (gameResult.isOnlyStrike()) {
            return gameResult.strikes() + STRIKE;
        }

        return gameResult.toString();
    }

    public boolean restartGame(String choice) {
        if (choice.equals(RESTART)) {
            return true;
        } else if (choice.equals(EXIT)) {
            return false;
        }

        throw new IllegalArgumentException("1 또는 2 중 하나의 유효한 입력이 필요합니다.");
    }
}
