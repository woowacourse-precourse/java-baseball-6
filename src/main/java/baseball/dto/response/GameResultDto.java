package baseball.dto.response;

import baseball.model.BaseBallGameResult;

public class GameResultDto {

    private final int strikeCount;
    private final int ballCount;

    public GameResultDto(BaseBallGameResult baseBallGameResult) {
        this.strikeCount = baseBallGameResult.getStrikeCount();
        this.ballCount = baseBallGameResult.getBallCount();
    }

    public int getBallCount() {
        return ballCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

}
