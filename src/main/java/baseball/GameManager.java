package baseball;

import static baseball.Message.CHOICE;
import static baseball.Message.COMPLETE;
import static baseball.Message.DESTINATION;
import static baseball.Message.EXIT;
import static baseball.Message.GAME_OVER;
import static baseball.Message.RESTART;

import java.util.List;


public class GameManager {

    private boolean isGameActive = true;

    public boolean isGameActive() {
        return isGameActive;
    }

    public void run() {
        UserInterface.printMessage(Message.START);

        while (isGameActive) {
            if (isGameActive) {
                playGame();
            }
        }
    }

    private void chooseNewGame() {
        System.out.println(CHOICE.getMessage());
        String response = UserInterface.requestUserInput();
        ExceptionHandler.handleExit(response);

        if (response.equals(RESTART.getMessage())) {
            isGameActive = true;
            Computer.resetGeneratedComputer();
        }

        if (response.equals(COMPLETE.getMessage())) {
            System.out.println(GAME_OVER.getMessage());
            isGameActive = false;
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
        int strike = result.getStrike();
        int ball = result.getBall();
        ResultMapper resultMapper = new ResultMapper();

        return resultMapper.getResult(strike, ball);
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

