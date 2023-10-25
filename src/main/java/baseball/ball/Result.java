package baseball.ball;

public class Result {
    private int nBall;
    private int nStrike;

    public Result(int nBall, int nStrike) {
        this.nBall = nBall;
        this.nStrike = nStrike;
    }

    public boolean chkResult(Result result) {
        return result.nStrike == 3;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (nBall == 0 && nStrike == 0) return "낫싱";
        if (nBall > 0) sb.append(nBall).append("볼");
        if (nBall > 0 && nStrike > 0) sb.append(" ");
        if (nStrike > 0) sb.append(nStrike).append("스트라이크");
        return sb.toString();
    }
}
