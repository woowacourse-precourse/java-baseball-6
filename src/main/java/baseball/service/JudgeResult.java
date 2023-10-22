package baseball.service;

import baseball.domain.Score;
import java.util.List;

public class JudgeResult {
    List<Integer> computerNum;
    List<Integer> playerNum;
    int ballCnt;
    int strikeCnt;

    public JudgeResult(List<Integer> computerNum, List<Integer> playerNum) {
        this.computerNum = computerNum;
        this.playerNum = playerNum;
        ballCnt = 0;
        strikeCnt = 0;
    }

    //이거 반환을 score로 해야될까, 아니면 string으로 해야될까?
    public String getResult() {
        findScore();
        Score scoreOutput = new Score(strikeCnt, ballCnt);
        return scoreOutput.getScoreOutput();
    }

    private void findScore() {
        for (int i = 0; i < playerNum.size(); i++) {
            strikeCnt += getStrikeCntHere(i);
            ballCnt += getBallCntHere(i);
        }
    }

    private int getStrikeCntHere(int playerIdx) {
        if (playerNum.get(playerIdx) == computerNum.get(playerIdx)) {
            return 1;
        }
        return 0;
    }

    private int getBallCntHere(int playerIdx) {
        for (int computerIdx = 0; computerIdx < computerNum.size(); computerIdx++) {
            if (computerIdx == playerIdx) {
                continue;
            }
            if (computerNum.get(computerIdx) == playerNum.get(playerIdx)) {
                return 1;
            }
        }
        return 0;
    }

}
