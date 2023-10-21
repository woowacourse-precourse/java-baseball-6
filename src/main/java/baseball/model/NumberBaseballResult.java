package baseball.model;

public class NumberBaseballResult {
    private int strikeCnt;
    private int ballCnt;

    public NumberBaseballResult(int strikeCnt, int ballCnt) {
        this.strikeCnt = strikeCnt;
        this.ballCnt = ballCnt;
    }

    public String generateResultString() {
        String resultStr = "";
        if(strikeCnt != 0 && ballCnt != 0) {
            resultStr =  ballCnt + "볼 " + strikeCnt + "스트라이크";
        }
        if (strikeCnt == 0 && ballCnt != 0) {
            resultStr = ballCnt + "볼";
        }
        if (strikeCnt != 0 && ballCnt == 0) {
            resultStr = strikeCnt + "스트라이크";
        }
        if (strikeCnt ==0 && ballCnt == 0) {
            resultStr = "낫싱";
        }

        return resultStr;
    }


}
