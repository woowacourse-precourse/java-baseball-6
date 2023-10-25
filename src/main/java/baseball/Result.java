package baseball;

public class Result {
    private int strike;
    private int ball;

    public Result(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public void toStringResult() {
        int strikeCnt = this.strike;
        int ballCnt = this.ball;

        if (strikeCnt == 0 && ballCnt == 0) {
            System.out.println("낫싱");
            return;
        }

        if (ballCnt > 0) {
            System.out.print(ballCnt + "볼 ");
        }

        if (strikeCnt > 0) {
            System.out.print(strikeCnt + "스트라이크");
        }
        System.out.println();
        return;
    }

    public boolean correctAllNumbers() {
        if (this.strike == 3) {
            return true;
        }
        return false;
    }
}
