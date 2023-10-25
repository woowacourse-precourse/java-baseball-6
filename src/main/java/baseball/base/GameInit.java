package baseball.base;

public class GameInit {
    String computerNumbers;
    int BallCount;
    int StrikeCount;

    public GameInit(String numbers){
        computerNumbers = numbers;
    }

    public String getComputerNumbers(){
        return computerNumbers;
    }

    public void initResult(){
        BallCount = 0;
        StrikeCount = 0;
    }

    public int getBallCount(){
        return BallCount;
    }
    public void setBallCount(int ballCount){
        this.BallCount = ballCount;
    }

    public int getStrikeCount(){
        return StrikeCount;
    }

    public void setStrikeCount(int strikeCount){
        this.StrikeCount = strikeCount;
    }
}
