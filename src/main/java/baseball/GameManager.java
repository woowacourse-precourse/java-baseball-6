package baseball;

import static baseball.Message.CHOICE;
import static baseball.Message.COMPLETE;
import static baseball.Message.DESTINATION;
import static baseball.Message.EXIT;
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
                chooseNewGame();
            }
        }
    }

    private void chooseNewGame() {
        System.out.println(CHOICE.getMessage());
        String response = UserInterface.requestUserInput();
        ExceptionHandler.handleExit(response);

        if (response.equals(RESTART.getMessage())) {
            isNewGame = true;
        }

        if (response.equals(COMPLETE.getMessage())) {
            isNewGame = false;
            return;
        }
    }

    private void playGame() {
        String inputResult = getInputResult();

        if (inputResult.equals(DESTINATION.getMessage())) {
            System.out.println(EXIT.getMessage());
        }

    }

    private String getInputResult() {
        String userInput = getRequest();
        Computer computer = new Computer();

        String inputResult = compareNumbers(userInput, computer.generateComputer());
        System.out.println(inputResult);
        return inputResult;
    }

    private static String getRequest() {
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
}

