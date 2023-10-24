package baseball.model;

public class AttemptResult {
    private int strikeCount;
    private int ballCount;

    public AttemptResult(){
        this.reset();
    }

    public void reset(){
        this.strikeCount = 0;
        this.ballCount = 0;
    }


    public int getStrikeCount(){
        return this.strikeCount;
    }

    public int getBallCount(){
        return this.ballCount;
    }
    public void incrementStrikeCount(){
        this.strikeCount++;
    }
    public void incrementBallCount(){
        this.ballCount++;
    }

    public String toString(){
        if ((this.ballCount + this.strikeCount) == 0){
            return "낫싱";
        }
        if (this.ballCount != 0){
            if (this.strikeCount != 0){
                return getBallCount() +"볼 " + getStrikeCount() + "스트라이크";
            }
            return getBallCount() +"볼";
        }
        return getStrikeCount() + "스트라이크";
    }
}