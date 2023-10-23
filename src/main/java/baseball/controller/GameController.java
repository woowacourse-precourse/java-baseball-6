package baseball.controller;

import baseball.model.RandomNumber;
import baseball.view.InputMessage;
import baseball.view.PrintMessage;

public class GameController {

    private static final int ALL_COLLECT = 3;
    private static final String START_GAME_OPTION = "1";

    private final InputMessage inputMessage = new InputMessage();
    private final InputValidation inputValidation = new InputValidation();
    private final PrintMessage printMessage = new PrintMessage();

    public void run() {
        printMessage.startMessage();
        boolean isStart = true;
        while (isStart) {
            playGame();
            isStart = isStartGame();
        }
    }

    private void playGame() {
        RandomNumber randomNumber = new RandomNumber();
        randomNumber.generateRandomNumber();

        boolean isFail = true;
        while (isFail) {
            printMessage.enterNumberMessage();
            String threeNumber = inputMessage.inputThreeNumber();
            inputValidation.validateNumber(threeNumber);
            int[] result = randomNumber.checkInputNumbers(threeNumber);
            printMessage.resultMessage(result[0], result[1]);
            if (result[1] == ALL_COLLECT) {
                isFail = false;
            }
        }
    }

    private boolean isStartGame() {
        printMessage.correctMessage();
        printMessage.menuMessage();
        String optionNumber = inputMessage.inputOptionNumber();
        inputValidation.validateOptionNumber(optionNumber);
        if (optionNumber.equals(START_GAME_OPTION)) {
            return true;
        }
        return false;
    }
}
