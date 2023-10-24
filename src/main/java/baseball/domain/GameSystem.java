package baseball.domain;

public class GameSystem {
    private String roundNumber;
    private Long strike;
    private Long ballCount;


    public String getRoundNumber() {
        return roundNumber;
    }

    public void setRoundNumber(String roundNumber) {
        this.roundNumber = roundNumber;
    }

    public Long getStrike() {
        return strike;
    }

    public void setStrike(Long strike) {
        this.strike = strike;
    }

    public Long getBallCount() {
        return ballCount;
    }

    public void setBallCount(Long ballCount) {
        this.ballCount = ballCount;
    }
}
