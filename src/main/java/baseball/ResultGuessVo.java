package baseball;
public class ResultGuessVo {
    private int cntBall;
    private int cntStrike;

    public ResultGuessVo(int cntBall, int cntStrike) {
        this.cntBall = cntBall;
        this.cntStrike = cntStrike;
    }

    public int getCntBall() {
        return cntBall;
    }

    public int getCntStrike() {
        return cntStrike;
    }
}
