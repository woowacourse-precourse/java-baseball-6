package baseball;

public class GameResult {
    private static final String BALL_TEXT = "볼";
    private static final String STRIKE_TEXT = "스트라이크";
    private static final String NOTING_TEXT = "낫싱";
    private static final String SPACE = " ";

    private Integer ballCount;
    private Integer strikeCount;

    public GameResult(int[] userNumbers, int[] computerNumbers) {
        this.ballCount = 0;
        this.strikeCount = 0;
        setBallCount(userNumbers, computerNumbers);
        setStrikeCount(userNumbers, computerNumbers);
    }

    public boolean isWin() {
        return this.strikeCount == 3;
    }

    public String getResult() {
        if (this.ballCount == 0 && this.strikeCount == 0) {
            return NOTING_TEXT;
        }
        if (this.ballCount == 0) {
            return this.strikeCount + STRIKE_TEXT;
        }
        if (this.strikeCount == 0) {
            return this.ballCount + BALL_TEXT;
        }
        return this.ballCount + BALL_TEXT + SPACE + this.strikeCount + STRIKE_TEXT;
    }

    private void setBallCount(int[] userNumbers, int[] computerNumbers) {
        for (int i = 0; i < 3; i++) {
            if (userNumbers[i] == computerNumbers[i]) {
                continue;
            }
            for (int j = 0; j < 3; j++) {
                if (userNumbers[i] == computerNumbers[j]) {
                    this.ballCount++;
                }
            }
        }
    }
    private void setStrikeCount(int[] userNumbers, int[] computerNumbers) {
        for (int i = 0; i < 3; i++) {
            if (userNumbers[i] == computerNumbers[i]) {
                this.strikeCount++;
            }
        }
    }
}
