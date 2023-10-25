package baseball.model;

public class MatchNumberModel {

    public int strikeNumber;
    public int ballNumber;

    public int getStrikeNumber() {
        return strikeNumber;
    }

    public int getBallNumber() {
        return ballNumber;
    }

    public void setStrikeNumber(int strikeNumber) {
        this.strikeNumber=strikeNumber;
    }

    public void setBallNumber(int ballNumber) {
        this.ballNumber=ballNumber;
    }

    public MatchNumberModel() {
        this.strikeNumber = 0;
        this.ballNumber = 0;
    }
}
