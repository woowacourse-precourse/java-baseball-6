package baseball.dto;

import baseball.model.RoundResult;

public class RoundResultDto {
    public boolean isNothing;
    public int ballCount;
    public int strikeCount;

    private RoundResultDto() {
    }

    public static RoundResultDto from(RoundResult roundResult) {
        RoundResultDto dto = new RoundResultDto();
        dto.isNothing = roundResult.isNothing();
        dto.ballCount = roundResult.provideBallCount();
        dto.strikeCount = roundResult.provideStrikeCount();
        return dto;
    }

    public boolean isNothing() {
        return isNothing;
    }

    public int getBallCount() {
        return ballCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }
}