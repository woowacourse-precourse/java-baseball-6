package baseball.model;

public class ResultRecord {
    private int strikeCountRecord;
    private int ballCountRecord;

    public ResultRecord(){
        strikeCountRecord = 0;
        ballCountRecord = 0;
    }
    public int getStrikeCount() {
        return strikeCountRecord;
    }
    public int getBallCount(){
        return ballCountRecord;
    }
    public void setStrikeCount(int count){
        strikeCountRecord = count;
    }
    public void setBallCount(int count){
        ballCountRecord = count;
    }
}
