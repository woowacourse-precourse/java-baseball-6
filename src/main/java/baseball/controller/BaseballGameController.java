package baseball.controller;

import baseball.domain.BaseballGame;
import baseball.domain.User;
import baseball.view.InputView;
import baseball.view.OutputView;


public class BaseballGameController {

    public static final String ALL_STRIKE = "3";
    public static final int STRIKE_COUNT_RESULT = 1;
    public static final String RESTART_GAME = "1";
    public static final String END_GAME = "2";


    private BaseballGame baseballGame;
    private User user;
    private Boolean RestartFlag = true;

    public BaseballGameController() {
        OutputView.printGameInitMessage();
    }

    public void gameStart() {
        this.baseballGame = new BaseballGame();
        this.user = new User();
        do {
            InputView.printInputNumberMessage();
            user.createUserNumber(InputView.readUserNumberInput());
            String[] results = baseballGame.compareTwoNumbers(user.getUserNumber());
            new OutputView(results);
            gameResult(results);
        } while (RestartFlag);

    }


    public void gameResult(String[] results) {
        if (results[STRIKE_COUNT_RESULT].equals(ALL_STRIKE)) {
            OutputView.printAnswerMessage();
            OutputView.printRestartGameMessage();
            String input = InputView.readRestartNumberInput();
            validateRestartNumber(input);
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


    public void validateRestartNumber(String input) {
        if (!input.equals(RESTART_GAME) && !input.equals(END_GAME)) throw new IllegalArgumentException();
    }


}
