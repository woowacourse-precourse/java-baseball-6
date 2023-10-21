package baseball.baseball.controller;

import baseball.baseball.model.BaseballService;
import baseball.baseball.util.StringConvertUtil;
import baseball.baseball.view.InputView;
import baseball.baseball.view.OutputView;

import java.util.List;

import static baseball.baseball.model.constants.INVALID_END_GAME_INPUT_ERROR;
import static baseball.baseball.model.constants.NUMBER_LENGTH_ERROR;

public class BaseballController {
    private static final BaseballService baseballService = new BaseballService();
    private static final OutputView outputView = OutputView.getInstance();
    private static final InputView inputView = InputView.getInstance();
    private static List<Integer> goalNumber;
    private static final String SUCCESS_MESSAGE = "3스트라이크";

    public void run() {
        start();
    }

    private void start() {
        boolean isEndGame = false;

        while (!isEndGame) {
            outputView.printStartGame();
            goalNumber = baseballService.createGoalNumber();

            game();

            isEndGame = endGame();
        }
    }

    private void game() {
        boolean isStopGame = false;

        while (!isStopGame) {
            List<Integer> inputNumber = getInputNumber();

            String hint = checkNumber(inputNumber);
            outputView.printHint(hint);

            isStopGame = hint.equals(SUCCESS_MESSAGE);
        }
    }

    private List<Integer> getInputNumber() {
        String inputString = inputView.getInputNumber();

        if (inputString.length() != 3) {
            throw new IllegalArgumentException(NUMBER_LENGTH_ERROR);
        }

        return StringConvertUtil.stringToIntList(inputString);
    }

    private String checkNumber(List<Integer> inputNumber) {
        return baseballService.checkNumber(goalNumber, inputNumber);
    }

    private boolean endGame() {
        int endGame;

        try {
            endGame = Integer.parseInt(inputView.getEndGame());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_END_GAME_INPUT_ERROR);
        }

        if (endGame != 1 && endGame != 2) {
            throw new IllegalArgumentException(INVALID_END_GAME_INPUT_ERROR);
        }

        return endGame == 2;
    }
}
