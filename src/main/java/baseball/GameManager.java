package baseball;

import static baseball.Message.CHOICE;
import static baseball.Message.COMPLETE;
import static baseball.Message.DESTINATION;
import static baseball.Message.EXIT;
import static baseball.Message.GAME_OVER;
import static baseball.Message.RESTART;

import java.util.List;


public class GameManager {

    private boolean isNewGame = true;

    public boolean isNewGame() {
        return isNewGame;
    }

    public void run() {
        UserInterface.printMessage(Message.START);

        while (isNewGame) {
            if (isNewGame) {
                playGame();
            }
        }
    }

    private void chooseNewGame() {
        System.out.println(CHOICE.getMessage());
        String response = UserInterface.requestUserInput();
        ExceptionHandler.handleExit(response);

        if (response.equals(RESTART.getMessage())) {
            isNewGame = true;
            Computer.resetGeneratedComputer();
        }

        if (response.equals(COMPLETE.getMessage())) {
            System.out.println(GAME_OVER.getMessage());
            isNewGame = false;
            return;
        }
    }

    private void playGame() {
        String inputResult = getInputResult();

        if (inputResult.equals(DESTINATION.getMessage())) {
            System.out.println(EXIT.getMessage());
            chooseNewGame();
        }
    }

    private String getRequest() {
        UserInterface.printMessage(Message.INPUT);
        String userInput = UserInterface.requestUserInput();
        System.out.println(userInput);
        ExceptionHandler.handleExecute(userInput);
        return userInput;
    }

    private String compareNumbers(String readLine, List<Integer> computer) {
        Comparing comparing = new Comparing();
        Result result = comparing.compareNumbers(readLine, computer);
        int equalsNumber = result.getEqualsNumber();
        int equalsPosition = result.getEqualsPosition();
        ResultMapper resultMapper = new ResultMapper();

        return resultMapper.getResult(equalsNumber, equalsPosition);
    }

    private String getCompareResult() {
        String userInput = getRequest();
        String inputResult = compareNumbers(userInput, Computer.generateComputer());
        return inputResult;
    }

    private String getInputResult() {
        String inputResult = getCompareResult();
        System.out.println(inputResult);
        return inputResult;
    }

}

