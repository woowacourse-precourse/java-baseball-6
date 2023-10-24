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
        systemMessage.printSystemMessage();
        List<Integer> number = generateRandomNum();
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
    }

    private void askRetry() {
        String input = userInput.sendRetryMessage();
        if (input.equals("1")) {
            randomNumber.setStrikeCount();
            randomNumber.setNumbers();
        } else {

        }
    }
}
