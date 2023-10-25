package baseball.domain;

public class Player {
    private ThreeNumbers playerNumber;
    private int ballCount;
    private int strikeCount;

    public void setPlayerNumber(ThreeNumbers playerNumber) {
        this.playerNumber = playerNumber;
    }

    public ThreeNumbers getPlayerNumber() {
        return playerNumber;
    }

    public int getBallCount() {
        return ballCount;
    }

    public void setBallCount(int ballCount) {
        this.ballCount = ballCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public void setStrikeCount(int strikeCount) {
        this.strikeCount = strikeCount;
    }
}
