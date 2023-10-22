package baseball;

public class RoundResult {
    int strikeCount;
    int ballCount;

    public RoundResult(){
        this.resetCount();
    }

    public void resetCount(){
        this.strikeCount = 0;
        this.ballCount = 0;
    }


    int getStrikeCount(){
        return this.strikeCount;
    }

    int getBallCount(){
        return this.ballCount;
    }
    public void addStrikeCount(){
        this.strikeCount++;
    }
    public void addBallCount(){
        this.ballCount++;
    }

    public String toString(){
        if ((this.ballCount + this.strikeCount) == 0){
            return "낫싱";
        }
        if (this.ballCount != 0){
            if (this.strikeCount != 0){
                return ballCount +"볼 " + strikeCount + "스트라이크";
            }
            return ballCount +"볼";
        }
        return strikeCount + "스트라이크";
    }
}
