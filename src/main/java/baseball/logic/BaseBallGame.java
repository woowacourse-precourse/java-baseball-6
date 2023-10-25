package baseball.logic;

import baseball.input.RestartInput;
import baseball.input.UserInput;
import baseball.output.Message;

import java.util.List;

public class BaseBallGame {
    List<Integer> answerNumbers, userInput;

    public void run() {
        Message.printStartMessage();
        boolean isRestart;

        do {
            gameLogic();
            isRestart = RestartInput.inputRestartNumber();
        } while (isRestart);
    }

    public void gameLogic() {
        CreateRandomNumbers createRandomNumbers = new CreateRandomNumbers();
        this.answerNumbers = createRandomNumbers.answerNumbers;

        boolean isAnswer;
        do {
            userInput = UserInput.inputNumbers();
            CompareLogic compareLogic = new CompareLogic(answerNumbers, userInput);
            isAnswer = compareLogic.isAnswer();
        } while (!isAnswer);
    }
}
