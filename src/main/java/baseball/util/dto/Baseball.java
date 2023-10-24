package baseball.util.dto;

public class Baseball {

    private int strikeNumber;
    private int ballNumber;
    private int nothingNumber;

    public Baseball(){
        strikeNumber = 0;
        ballNumber = 0;
        nothingNumber = 0;
    }

    public void incrementStrikeCount(){
        this.strikeNumber++;
    }

    public void incrementBallCount(){
        this.ballNumber++;
    }

    public void incrementNothingCount(){
        this.nothingNumber++;
    }

    public int getStrikeNumber() {
        return strikeNumber;
    }

    public int getBallNumber() {
        return ballNumber;
    }

    public int getNothingNumber() {
        return nothingNumber;
    }
}
