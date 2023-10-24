package baseball.service;

import baseball.utils.RandomNumber;
import baseball.view.SystemMessage;
import baseball.view.UserInput;
import java.util.List;

public class GameService {
    RandomNumber randomNumber = new RandomNumber();
    SystemMessage systemMessage = new SystemMessage();
    UserInput userInput = new UserInput();

    public void runGame() {
        startMessage();
        setGame();
    }

    private void startMessage() {
        systemMessage.printSystemMessage();
    }

    private void setGame() {
        List<Integer> number = generateRandomNum();
        randomNumber.setStrikeCount();
        while (randomNumber.getStrikeCount() != 3) {
            handleUserInput(number);
            if (randomNumber.getStrikeCount() == 3) {
                systemMessage.printGameEndMessage();
                askRetry();
            }
        }
    }

    private List<Integer> generateRandomNum() {
        randomNumber.setNumbers();
        return randomNumber.getNumbers();
    }

    private void handleUserInput(List<Integer> number) {
        String input = userInput.requestUserInput();
        randomNumber.compareNumbers(number, input);
        randomNumber.comparedResult();
    }

    private void askRetry() {
        String input = userInput.sendRetryMessage();
        String RESTART_COMMAND = "1";
        String END_COMMAND = "2";
        if (!input.equals(RESTART_COMMAND) && !input.equals(END_COMMAND)) {
            throw new IllegalArgumentException();
        } else {
            if (input.equals(RESTART_COMMAND)) {
                setGame();
            }
        }
    }
}
