package baseball.game.model.dto;

/**
 * 한 라운드 결과를 전달하는 DTO 클래스
 */
public class RoundResult {
    private final int ballCount;

    private final int strikeCount;

    public RoundResult(int ballCount, int strikeCount) {
        this.ballCount = ballCount;
        this.strikeCount = strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }
}
