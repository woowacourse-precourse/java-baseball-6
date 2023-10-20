package baseball.gameLogic;

import baseball.gameLogic.*;
import camp.nextstep.edu.missionutils.Console;
import baseball.userInterface.MessageViewer;
import baseball.models.Score;
import static baseball.models.Constants.*;

/*
  게임 구동을 담당하는 메인 클래스
*/

public class NumberBaseBall {
    NumberChecker numberChecker;
    InputValidator inputValidator;
    MessageViewer messageViewer;
    Score score;
    UserAction userAction;
    ComputerAction computerAction;

    public void init(){
        numberChecker = new NumberChecker();
        inputValidator = new InputValidator();
        messageViewer = new MessageViewer();
        computerAction = new ComputerAction();
        userAction = new UserAction();

        computerAction.generateNumber();
    }

    public void run(){
        int mind = WANNA_KEEP_PLAYING;

        messageViewer.printStartMsg();

        while (mind == WANNA_KEEP_PLAYING){
            messageViewer.printInputRequestMsg();
            userAction.inputAnswer(inputValidator);
            score = numberChecker.checkNumber(userAction.getNumberList(), computerAction.getNumberList());

            int ballCount = score.ballCount;
            int strikeCount = score.strikeCount;
            messageViewer.printResultMsg(ballCount, strikeCount);

            mind = checkKeepGoing(strikeCount);
        }
    }

    public int checkKeepGoing(int strikeCount){
        if (strikeCount == MAX_STRIKES) {
            messageViewer.printGameEndMsg();
            userAction.inputRestartFactor(inputValidator);

            int mind = userAction.getMind();
            regenerateNumber(mind);

            return mind;
        }

        return WANNA_KEEP_PLAYING;
    }

    public void regenerateNumber(int mind){
        if (mind == WANNA_KEEP_PLAYING)
            computerAction.generateNumber();
    }
}
