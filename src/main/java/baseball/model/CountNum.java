package baseball.model;

public class CountNum {

    private int strikeNum;
    private int ballNum;

    public CountNum(int strikeNum,int ballNum){
        this.strikeNum=strikeNum;
        this.ballNum=ballNum;
    }

    public int getStrikeNum(){
        return this.strikeNum;
    }

    public int getBallNum(){
        return this.ballNum;
    }

}
