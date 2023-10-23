package baseball.controller;

import baseball.domain.BaseballGame;
import baseball.domain.User;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballGameController {

    private BaseballGame baseballGame;
    private User user;
    private Boolean RestartFlag = true;

    public BaseballGameController() {
        OutputView.printGameInitMessage();
    }

    public void gameStart() {
        this.baseballGame=new BaseballGame();
        this.user = new User();
        do {
            InputView.printInputNumberMessage();
            user.createUserNumber(InputView.readUserNumberInput());
            String []results = baseballGame.compareTwoNumbers(user.getUserNumber());
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


    public void validateRestartNumber(String input) {
        if (!input.equals("1") && !input.equals("2")) throw new IllegalArgumentException();
    }


}
