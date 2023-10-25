package baseball.game;

import baseball.utils.BaseballUtil;
import baseball.view.GameMessage;

import java.util.ArrayList;

public class Setting {
    private static final int ALL_STRIKE_CNT = 3;
    private int strikeCnt;
    private int ballCnt;

    public boolean isNotAllStrike(){
        return strikeCnt != ALL_STRIKE_CNT;
    }
    public void loadCorrectStatus(ArrayList<Integer> computerNumbers, ArrayList<Integer> playerNumbers){
        setCorrectCount(computerNumbers, playerNumbers);
        printCorrectStatus();
    }
    public void setCorrectCount(ArrayList<Integer> computerNumbers, ArrayList<Integer> playerNumbers){
        strikeCnt = BaseballUtil.equalBetweenStrike(computerNumbers, playerNumbers);
        ballCnt = BaseballUtil.equalBetweenBall(computerNumbers, playerNumbers);
    }
    public void printCorrectStatus(){
        GameMessage.printGameHintsMessage(strikeCnt, ballCnt);
    }
}
