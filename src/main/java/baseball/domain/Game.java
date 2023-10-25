package baseball.domain;

public class Game {
    int strikeCnt;
    int ballCnt;
    int[] gameNums;

    public Game(int[] gameNums) {
        this.gameNums = gameNums;
    }

    public void initGameCnt(){
        this.strikeCnt = 0;
        this.ballCnt = 0;
    }

    public int getStrikeCnt() {
        return strikeCnt;
    }

    public void setStrikeCnt(int strikeCnt) {
        this.strikeCnt = strikeCnt;
    }

    public int getBallCnt() {
        return ballCnt;
    }

    public void setBallCnt(int ballCnt) {
        this.ballCnt = ballCnt;
    }

    public int[] getGameNums() {
        return gameNums;
    }

    public void setGameNums(int[] gameNums) {
        this.gameNums = gameNums;
    }
}
