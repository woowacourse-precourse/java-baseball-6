package baseball;

import baseball.util.PrintMessage;

public class GameResult {
    private boolean isSuccess;
    private int ballCnt;
    private int strikeCnt;
    public GameResult() {
    }

    public void addBallCnt(){
        ballCnt += 1;
    }

    public void addStrikeCnt(){
        strikeCnt+= 1;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public int getStrikeCnt() {
        return strikeCnt;
    }

    @Override
    public String toString() {
        return "GameResult{" +
                "isSuccess=" + isSuccess +
                ", ballCnt=" + ballCnt +
                ", strikeCnt=" + strikeCnt +
                '}';
    }

    public void printGameResult(){
        //ball 과 스트라이크 모두 개수가 0이 아니고 있다면
        if (ballCnt > 0 && strikeCnt > 0)
            PrintMessage.printBallAndStrikeMessage(ballCnt, strikeCnt);

        //ball만 있는 경우
        if (ballCnt > 0 && strikeCnt == 0)
            PrintMessage.printBallMessage(ballCnt);

        //strike만 있는 경우
        if (ballCnt == 0 && strikeCnt > 0)
            PrintMessage.printStrikeMessage(strikeCnt);

        //아무것도 없다면 낫싱
        if (ballCnt == 0 && strikeCnt == 0)
            PrintMessage.printNothingMessage();
    }
}
