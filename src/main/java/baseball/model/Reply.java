package baseball.model;

import java.util.List;
import java.util.Objects;

public class Reply {

    List<Integer> computerNumber;
    List<Integer> playerNumber;
    int ballCnt;
    int strikeCnt;

    public Reply(List<Integer> computerNumber, List<Integer> playerNumber) {
        this.computerNumber = computerNumber;
        this.playerNumber = playerNumber;
    }

    public void setBallAndStrike() {
        int ballCnt = 0;
        int strikeCnt = 0;

        for (int i = 0; i < playerNumber.size(); i++) {
            for (int j = 0; j < computerNumber.size(); j++) {
                if (Objects.equals(playerNumber.get(i), computerNumber.get(j)) && i == j) {
                    strikeCnt++;
                    break;
                }
                if (Objects.equals(playerNumber.get(i), computerNumber.get(j))) {
                    ballCnt++;
                    break;
                }
            }
        }

        setBallCnt(ballCnt);
        setStrikeCnt(strikeCnt);
    }

    public void setBallCnt(int ballCnt) {
        this.ballCnt = ballCnt;
    }

    public int getBallCnt() {
        return ballCnt;
    }

    public void setStrikeCnt(int strikeCnt) {
        this.strikeCnt = strikeCnt;
    }

    public int getStrikeCnt() {
        return strikeCnt;
    }
}
