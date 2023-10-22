package baseball.gameLogic;

import baseball.models.Score;

import java.util.List;

import static baseball.userInterface.MessageViewer.*;
import static baseball.utils.Constants.*;

/*
  게임 구동을 담당하는 메인 클래스
*/

public class NumberBaseBall {
    NumberChecker numberChecker;
    ComputerAction computerAction;
    UserAction userAction;
    Score score;

    List<Integer> computerNumList, userNumList;

    int gameStatus;


    public void init(){
        numberChecker = new NumberChecker();
        computerAction = new ComputerAction();
        userAction = new UserAction();

        gameStatus = WANNA_KEEP_PLAYING;
    }

    public void run(){
        generateComputerNumber();
        printStartMsg();

        while (gameStatus == WANNA_KEEP_PLAYING){
            getUserAnswer();
            getScore();
            printResultMsg(score.ballCount, score.strikeCount);
            checkKeepPlaying(score.strikeCount);
        }
    }

    public void generateComputerNumber(){
        generateNumber();
        computerNumList = computerAction.showNumberList();
    }

    public void getScore(){
        score = numberChecker.checkNumber(userNumList, computerNumList);
    }

    public void getUserAnswer(){
        userAction.inputAnswer();
        userNumList = userAction.showNumberList();
    }

    public void checkKeepPlaying(int strikeCount){
        userAction.clearAnswer();

        if (strikeCount == MAX_STRIKES) {
            printGameEndMsg();

            userAction.inputRestartFactor();
            gameStatus = userAction.showMind();

            generateNumber();
        }
    }

    public void generateNumber(){
        if (gameStatus == WANNA_KEEP_PLAYING) {
            computerAction.clearAnswer();
            computerAction.generateNumber();
            computerNumList = computerAction.showNumberList();
        }
    }

}
