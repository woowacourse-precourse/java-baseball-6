package baseball.controller;

import baseball.domain.BaseballGame;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballGameController {

    private BaseballGame baseballGame;
    private Boolean RestartFlag = true;

    public BaseballGameController() {
        OutputView.printGameInitMessage();
    }

    public void gameStart() {
        String userNumber;
        this.baseballGame=new BaseballGame();
        baseballGame.createComputerNumber();
        do {
            InputView.printInputNumberMessage();
            userNumber = InputView.readUserNumberInput();
            validateUserNumber(userNumber);
            String result = baseballGame.compareTwoNumbers(userNumber);
            String [] results = baseballGame.splitCountResult(result);
            new OutputView(results);

            gameResult(results);

        } while (RestartFlag);

    }


    public void gameResult(String [] results){

        if (results[1].equals("3")) {
            OutputView.printAnswerMessage();
            OutputView.printRestartGameMessage();
            String input = InputView.readRestartNumberInput();
            validateRestartNumber(input);
            restartGame(input);
        }

    }


    public void restartGame(String input){
        if (input.equals("1")) {
            baseballGame.createComputerNumber();
        }
        if (input.equals("2")) {
            RestartFlag = false;
        }
    }
















    public void validateUserNumber(String userNumber) {
        if (userNumber.length() != 3) throw new IllegalArgumentException();

        for (int i = 0; i < userNumber.length(); i++) {
            if (userNumber.charAt(i) - '0' < 1 || userNumber.charAt(i) - '0' > 9) {
                throw new IllegalArgumentException();
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = i + 1; j < 3; j++) {
                if (userNumber.charAt(i) == userNumber.charAt(j)) {
                    throw new IllegalArgumentException();
                }
            }
        }
    }

    public void validateRestartNumber(String input) {
        if (!input.equals("1") && !input.equals("2")) throw new IllegalArgumentException();

    }


}
