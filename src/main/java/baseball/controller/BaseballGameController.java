package baseball.controller;

import baseball.domain.BaseballGame;
import baseball.domain.User;
import baseball.view.InputView;
import baseball.view.OutputView;


public class BaseballGameController {


    private static final String ALL_STRIKE = "3";
    private static final int STRIKE_COUNT_RESULT = 1;
    private static final String RESTART_GAME = "1";
    private static final String END_GAME = "2";

    private BaseballGame baseballGame;
    private User user;
    private Boolean RestartFlag = true;

    public BaseballGameController() {
        OutputView.printGameInitMessage();
    }

    public void gameStart() {
        this.baseballGame = new BaseballGame();
        do {
            InputView.printInputNumberMessage();
            baseballGame.createUserNumber(InputView.readUserNumberInput());
            String[] results = baseballGame.compareTwoNumbers();
            new OutputView(results);
            gameResult(results);
        } while (RestartFlag);

    }


    public void gameResult(String[] results) {
        if (results[STRIKE_COUNT_RESULT].equals(ALL_STRIKE)) {
            this.user = new User();
            OutputView.printAnswerMessage();
            OutputView.printRestartGameMessage();
            String input = InputView.readRestartNumberInput();
            user.validateRestartUserInput(input);
            restartGame(input);
        }

    }


    public void restartGame(String input) {
        if (input.equals(RESTART_GAME)) {
            baseballGame.createComputerNumber();
        }
        if (input.equals(END_GAME)) {
            RestartFlag = false;
        }
    }


}
