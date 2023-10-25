package baseball.model;

import java.util.List;

public class GameResultDto {
    private int strikeCount;
    private int ballCount;
    public GameResultDto(){}

    public int getStrikeCount(){
        return this.strikeCount;
    }

    public int getBallCount(){
        return this.ballCount;
    }

    public void setStrikeCount(int strikeCount){
        this.strikeCount = strikeCount;
    }

    public void setBallCount(int ballCount){
        this.ballCount = ballCount;
    }
}
