package baseball.service;

import baseball.domain.Computer;
import baseball.domain.Player;
import baseball.domain.Score;
import java.util.List;

public class JudgeResult {
    List<Integer> computerNum;
    List<Integer> playerNum;
    int ballCnt;
    int strikeCnt;

    public JudgeResult(Computer computer, Player player) {
        this.computerNum = computer.getComputerNums();
        this.playerNum = player.getInputNums();
        ballCnt = 0;
        strikeCnt = 0;
    }

    //이거 반환을 score로 해야될까, 아니면 string으로 해야될까?
    public String getResult() {
        findScore();
        Score scoreOutput = new Score(strikeCnt, ballCnt);
        return scoreOutput.getScoreOutput();
    }

    public boolean isGameClear() {
        return strikeCnt == 3;
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
