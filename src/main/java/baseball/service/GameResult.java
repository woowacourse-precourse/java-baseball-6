package baseball.service;

public class GameResult {
    private static final String NOTHING = "낫싱";
    private static final String STRIKE = "%d스트라이크";
    private static final String BALL = "%d볼 ";
    private final String hint;

    public GameResult(int ballCount, int strikeCount) {
        this.hint = calculateResult(ballCount, strikeCount);
    }

    private String calculateResult(int ballCount, int strikeCount) {
        StringBuilder result = new StringBuilder();
        if (appendingNothing(ballCount, strikeCount, result)) {
            return result.toString();
        }
        appendingBall(ballCount, result);
        appendingStrike(strikeCount, result);
        return result.toString().trim();
    }

    private void appendingStrike(int strikeCount, StringBuilder result) {
        if (strikeCount > 0) {
            result.append(String.format(STRIKE, strikeCount));
        }
    }

    private void appendingBall(int ballCount, StringBuilder result) {
        if (ballCount > 0) {
            result.append(String.format(BALL, ballCount));
        }
    }

    private boolean appendingNothing(int ballCount, int strikeCount, StringBuilder result) {
        if (ballCount == 0 && strikeCount == 0) {
            result.append(NOTHING);
            return true;
        }
        return false;
    }

    // 기능: 힌트가 3스트라이크면 게임 종료
    public boolean isGameEnd() {
        return hint.equals("3스트라이크");
    }

    public String getHint() {
        return hint;
    }
}


