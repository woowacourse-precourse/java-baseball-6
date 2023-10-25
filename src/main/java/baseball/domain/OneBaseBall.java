package domain;

import lombok.Getter;

@Getter
public class OneBaseBall {
    private BaseBallNumber baseBallNumber;
    private Integer baseBallPosition;

    private OneBaseBall(BaseBallNumber baseBallNumber, integer baseBallPosition){
        this.baseBallNumber=baseBallNumber;
        this.baseBallPosition=baseBallPosition;
    }

    public static OneBaseBall ofInteger(Integer baseBallPosition, Integer baseBallPosition){
        return new OneBaseBall(BaseBallNumber.of(baseBallNumber), baseBallPosition);
    }

    public boolean equalStrike(OneBaseBall otherBaseBall){
        return this.baseBallNumber.equals(otherBaseBall.baseBallNumber) && this.baseBallPosition.equals(otherBaseBall.getBaseBallPosition());
    }

    public boolean equalBall(OneBaseBall otherBaseBall){
        return this.baseBallNumber.equals(otherBaseBall.baseBallNumber) && !this.baseBallPosition.equals(otherBaseBall.getBaseBallPosition());
    }
}