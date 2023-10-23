package baseball;

import static baseball.Message.INPUT_RIGHT_NUMBER;
import static baseball.Message.INPUT_THREE_NUMBER;

import java.util.List;

public class GameManager {

    private boolean isGameActive;

    public GameManager() {
        this.isGameActive = true;
    }

    public void run() {
        UserInterface.printMessage(Message.START);

        while(isGameActive) {
            playGame();
            handleGameResult();
        }
    }

    private void playGame() {
        UserInterface.printMessage(Message.INPUT);
        String user = UserInterface.getUser();


        try {
            validateUserInput(user);

            List<Integer> computer = Computer.generateComputer();
            Comparing comparing = new Comparing();
            Result result = comparing.compareNumbers(user, computer);
            String resultForUi = ResultMapper.getResult(result.getEqualsNumber() , result.getEqualsPosition());

            System.out.println(resultForUi);

        } catch (IllegalArgumentException e) {
            System.out.println(INPUT_THREE_NUMBER.getMessage());
        }
    }

    private void validateUserInput(String user) {
        ExceptionHandler exceptionHandler = new ExceptionHandler(user);
        exceptionHandler.handleExecute(user);
    }

    public void handleGameResult() {
        UserInterface.printMessage(Message.EXIT);
        String response = UserInterface.getUser();
        ExceptionHandler exceptionHandler = new ExceptionHandler(response);

        try {
            exceptionHandler.handleExit(response);
            int input = Integer.parseInt(response);

            if (input != 2) {
                isGameActive = false;
                UserInterface.printMessage(Message.EXIT);
            }
        } catch (IllegalArgumentException e) {
            System.out.println(INPUT_RIGHT_NUMBER.getMessage());

        }
    }

}
