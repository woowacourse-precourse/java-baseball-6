package baseball;

import baseball.gameLogic.*;
import camp.nextstep.edu.missionutils.Console;
import baseball.userInterface.MessageViewer;
import baseball.models.Score;
import static baseball.models.Constants.*;


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
            messageViewer.printResultMsg(score.ballCount, score.strikeCount);

            mind = checkKeepGoing(score.strikeCount);
        }
    }

    public int checkKeepGoing(int strikeCount){
        if (strikeCount == MAX_STRIKES) {
            messageViewer.printGameEndMsg();
            userAction.inputRestartFactor(inputValidator);
            regenerateNumber(userAction.user.mind);

            return userAction.user.mind;
        }

        return WANNA_KEEP_PLAYING;
    }

    public void regenerateNumber(int mind){
        if (mind == WANNA_KEEP_PLAYING)
            computerAction.generateNumber();
    }
}
