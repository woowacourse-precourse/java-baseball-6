package baseball.runner.dto;

public class ResponseDto {
    int strikeCount;
    int ballCount;

    public static ResponseDto builder() {
        return new ResponseDto();
    }

    public ResponseDto strikeCount(int strikeCount) {
        this.strikeCount = strikeCount;
        return this;
    }

    public ResponseDto ballCount(int ballCount) {
        this.ballCount = ballCount;
        return this;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public int getBallCount() {
        return ballCount;
    }
}
