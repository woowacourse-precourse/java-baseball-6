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
    int gameStatus;

    public void init(){
        numberChecker = new NumberChecker();
        messageViewer = new MessageViewer();
        computerAction = new ComputerAction();
        userAction = new UserAction();

        gameStatus = WANNA_KEEP_PLAYING;
    }

    public void run(){
        Score score;

        computerAction.generateNumber();
        computerNumList = computerAction.getNumberList();

        messageViewer.printStartMsg();

        while (gameStatus == WANNA_KEEP_PLAYING){
            messageViewer.printInputRequestMsg();
            System.out.println(computerNumList.get(0) + "" + computerNumList.get(1) + "" + computerNumList.get(2));
            userAction.inputAnswer();
            userNumList = userAction.showNumberList();
            System.out.println(userNumList.get(0) + "" + userNumList.get(1) + "" + userNumList.get(2));

            score = numberChecker.checkNumber(userNumList, computerNumList);
            messageViewer.printResultMsg(score.ballCount, score.strikeCount);

            checkKeepPlaying(score.strikeCount);

            userAction.clearAnswer();
        }
    }

    public void checkKeepPlaying(int strikeCount){
        if (strikeCount == MAX_STRIKES) {
            messageViewer.printGameEndMsg();

            userAction.inputRestartFactor();
            gameStatus = userAction.showMind();

            regenerateNumber();
        }
    }

    public void regenerateNumber(){
        if (gameStatus == WANNA_KEEP_PLAYING) {
            computerAction.generateNumber();
            computerNumList = computerAction.getNumberList();
        }
    }

}
