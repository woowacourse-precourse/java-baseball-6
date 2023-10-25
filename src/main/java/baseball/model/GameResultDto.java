package baseball.model;

import java.util.List;

public class GameResultDto {
    private int strikeCount;
    private int ballCount;
    private boolean isCorrectNumber;

    public GameResultDto(){}

    public int getStrikeCount(){
        return this.strikeCount;
    }

    public int getBallCount(){
        return this.ballCount;
    }

    public boolean getIsCorrectNumber(){
        return this.isCorrectNumber;
    }

    public void setStrikeCount(int strikeCount){
        this.strikeCount = strikeCount;
    }

    public void setBallCount(int ballCount){
        this.ballCount = ballCount;
    }

    public void setIsCorrectNumber(boolean isCorrectNumber){
        this.isCorrectNumber = isCorrectNumber;
    }
}
