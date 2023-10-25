package baseballgame;

public class BallCount {
    public int ballCnt;
    public int strikeCnt;

    BallCount(){
        ballCnt = 0;
        strikeCnt = 0;
    }

    public void initValues(){
        setBallCnt(0);
        setStrikeCnt(0);
    }

    public int getBallCnt(){
        return ballCnt;
    }

    public void setBallCnt(int cnt){
        ballCnt = cnt;
    }

    public void addOneBallCnt(){
        ballCnt+=1;
    }

    public int getStrikeCnt(){
        return strikeCnt;
    }

    public void setStrikeCnt(int cnt){
        strikeCnt = cnt;
    }

    public void addOneStrikeCnt(){
        strikeCnt+=1;
    }

}
