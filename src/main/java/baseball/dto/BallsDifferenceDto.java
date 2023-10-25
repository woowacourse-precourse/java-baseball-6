package baseball.dto;

public class BallsDifferenceDto {

    private final int sameBallCount;
    private final int sameValueBallCount;
    private final int differentBallCount;

    public BallsDifferenceDto(int sameBallCount, int sameValueBallCount, int differentBallCount) {
        this.sameBallCount = sameBallCount;
        this.sameValueBallCount = sameValueBallCount;
        this.differentBallCount = differentBallCount;
    }

    public int getSameBallCount() {
        return this.sameBallCount;
    }

    public int getSameValueBallCount() {
        return this.sameValueBallCount;
    }

    public int getDifferentBallCount() {
        return this.differentBallCount;
    }

}
