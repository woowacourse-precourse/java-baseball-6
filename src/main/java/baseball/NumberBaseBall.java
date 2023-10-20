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
    UserAction user;
    ComputerAction computer;

    public void init(){
        numberChecker = new NumberChecker();
        inputValidator = new InputValidator();
        messageViewer = new MessageViewer();
        computer = new ComputerAction();
        user = new UserAction();

        computer.generateNumber();
    }

    public void run(){
        int mind = WANNA_KEEP_PLAYING;

        messageViewer.printStartMsg();

        while (mind == WANNA_KEEP_PLAYING){
            messageViewer.printInputRequestMsg();
            System.out.println(computer.numberList.get(0) + "" + computer.numberList.get(1) + "" + computer.numberList.get(2));
            user.inputAnswer(inputValidator);
            score = numberChecker.checkNumber(user.numberList, computer.numberList);
            messageViewer.printResultMsg(score.ballCount, score.strikeCount);

            mind = checkKeepGoing(score.strikeCount);
        }
    }

    public int checkKeepGoing(int strikeCount){
        if (strikeCount == MAX_STRIKES) {
            messageViewer.printGameEndMsg();
            messageViewer.printRestartMsg();
            user.inputRestartFactor(inputValidator);
            regenerateNumber(user.mind);

            return user.mind;
        }

        return WANNA_KEEP_PLAYING;
    }

    public void regenerateNumber(int mind){
        if (mind == WANNA_KEEP_PLAYING)
            computer.generateNumber();
    }
}
