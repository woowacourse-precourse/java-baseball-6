package baseball;

import camp.nextstep.edu.missionutils.Console;
import baseball.userInterface.MessageViewer;
import java.util.List;

public class NumberBaseBall {
    RandomNumberGenerator randomNumberGenerator;
    NumberChecker numberChecker;
    InputValidator inputValidator;
    List<Integer> computer;
    MessageViewer messageViewer;
    public void init(){
        randomNumberGenerator = new RandomNumberGenerator();
        numberChecker = new NumberChecker();
        inputValidator = new InputValidator();
        computer = randomNumberGenerator.generateRandomNumber();
        messageViewer = new MessageViewer();
    }

    public void run(){
        boolean keepGoing = true;
        messageViewer.printStartMsg();
        while (keepGoing){
            messageViewer.printInputRequestMsg();
            System.out.println(computer.get(0) + " " + computer.get(1) + " " + computer.get(2));
            List<Integer> user = inputValidator.validateUserAnswer(Console.readLine());
            System.out.println(user.get(0) + " " + user.get(1) + " " + user.get(2));
            int[] results = numberChecker.checkNumber(user, computer);
            int ballCounts = results[0];
            int strikeCounts = results[1];
            messageViewer.printResultMsg(ballCounts, strikeCounts);
            if(strikeCounts == 3){
                messageViewer.printGameEndMsg();
                messageViewer.printRestartMsg();
                int restart = inputValidator.validateRestartInput(Console.readLine());

                if (restart == 1)
                    computer = randomNumberGenerator.generateRandomNumber();
                else if (restart == 2)
                    keepGoing = false;

            }
        }
    }
}
