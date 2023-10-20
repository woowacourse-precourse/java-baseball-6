package baseball;

import baseball.gameLogic.InputValidator;
import baseball.gameLogic.NumberChecker;
import baseball.gameLogic.RandomNumberGenerator;
import baseball.gameLogic.User;
import camp.nextstep.edu.missionutils.Console;
import baseball.userInterface.MessageViewer;
import baseball.models.Score;
import static baseball.models.Constants.*;

import java.util.List;


public class NumberBaseBall {
    RandomNumberGenerator randomNumberGenerator;
    NumberChecker numberChecker;
    InputValidator inputValidator;
    List<Integer> computer;
    MessageViewer messageViewer;
    Score score;
    User user;

    public void init(){
        randomNumberGenerator = new RandomNumberGenerator();
        numberChecker = new NumberChecker();
        inputValidator = new InputValidator();
        computer = randomNumberGenerator.generateRandomNumber();
        messageViewer = new MessageViewer();
        user = new User();

    }

    public void run(){
        boolean keepGoing = true;
        messageViewer.printStartMsg();
        while (keepGoing){
            messageViewer.printInputRequestMsg();
            System.out.println(computer.get(0) + " " + computer.get(1) + " " + computer.get(2));
//            List<Integer> user = inputValidator.validateUserAnswer(Console.readLine());
            user.inputAnswer(inputValidator);
            System.out.println(user.numberList.get(0) + " " + user.numberList.get(1) + " " + user.numberList.get(2));
            score = numberChecker.checkNumber(user.numberList, computer);
            messageViewer.printResultMsg(score.ballCount, score.strikeCount);
            if(score.strikeCount == MAX_STRIKES){
                messageViewer.printGameEndMsg();
                messageViewer.printRestartMsg();
                int restart = inputValidator.validateRestartInput(Console.readLine());
                if (restart == RESTART_NUMBER)
                    computer = randomNumberGenerator.generateRandomNumber();
                else if (restart == END_NUMBER)
                    keepGoing = false;

            }
        }
    }
}
