package baseball.gameLogic;

import baseball.userInterface.MessageViewer;
import baseball.models.Score;

import java.util.List;

import static baseball.models.Constants.*;

/*
  게임 구동을 담당하는 메인 클래스
*/

public class NumberBaseBall {
    NumberChecker numberChecker;
    MessageViewer messageViewer;
    ComputerAction computerAction;
    UserAction userAction;

    List<Integer> computerNumList, userNumList;
    int mind;

    public void init(){
        numberChecker = new NumberChecker();
        messageViewer = new MessageViewer();
        computerAction = new ComputerAction();
        userAction = new UserAction();

        mind = WANNA_KEEP_PLAYING;
    }

    public void run(){
        Score score;

        computerAction.generateNumber();
        computerNumList = computerAction.getNumberList();

        messageViewer.printStartMsg();

        while (mind == WANNA_KEEP_PLAYING){
            messageViewer.printInputRequestMsg();

            userAction.inputAnswer();
            userNumList = userAction.getNumberList();

            score = numberChecker.checkNumber(userNumList, computerNumList);

            messageViewer.printResultMsg(score.ballCount, score.strikeCount);

            checkKeepPlaying(score.strikeCount);
        }
    }

    public void checkKeepPlaying(int strikeCount){
        if (strikeCount == MAX_STRIKES) {
            messageViewer.printGameEndMsg();

            userAction.inputRestartFactor();
            mind = userAction.showMind();

            regenerateNumber();
        }
    }

    public void regenerateNumber(){
        if (mind == WANNA_KEEP_PLAYING) {
            computerAction.generateNumber();
            computerNumList = computerAction.getNumberList();
        }
    }

}
