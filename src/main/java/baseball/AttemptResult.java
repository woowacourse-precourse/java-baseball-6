package baseball;

public class AttemptResult {
    int strikeCount;
    int ballCount;

    public AttemptResult(){
        this.reset();
    }

    public void reset(){
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
                return getBallCount() +"볼 " + getStrikeCount() + "스트라이크";
            }
            return getBallCount() +"볼";
        }
        return getStrikeCount() + "스트라이크";
    }
}
