package baseball.game;

import baseball.utils.BaseballUtil;
import baseball.view.GameMessage;

import java.util.ArrayList;

public class Setting {
    int strikeCnt;
    int ballCnt;

    public boolean isNotAllStrike(){
        return strikeCnt != 3;
    }
    public void getCorrectStatus(ArrayList<Integer> computerNumbers, ArrayList<Integer> playerNumbers){
        getCorrectCount(computerNumbers, playerNumbers);
        printCorrectStatus();
    }
    public void getCorrectCount(ArrayList<Integer> computerNumbers, ArrayList<Integer> playerNumbers){
        strikeCnt = BaseballUtil.equalBetweenStrike(computerNumbers, playerNumbers);
        ballCnt = BaseballUtil.equalBetweenBall(computerNumbers, playerNumbers);
    }
    public void printCorrectStatus(){
        GameMessage.printGameHintsMessage(strikeCnt, ballCnt);
    }
}
