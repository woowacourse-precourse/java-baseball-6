package baseball.controller;

import baseball.model.GameResult;
import baseball.model.Numbers;
import baseball.model.numberstrategy.RandomNumberSelectionStrategy;
import baseball.model.numberstrategy.UserInputNumberSelectionStrategy;
import baseball.view.HintView;
import baseball.view.InputView;
import baseball.view.MessageView;

public class BaseballGame {
    private static final String RETRY = "1";
    private static final String END_GAME = "2";
    private static final String INVALID_INPUT_MESSAGE = "올바른 수를 입력하세요.";

    public void play() {
        MessageView.printStartMessage();
        do {
            start();
        } while (askRestartOrExit());
    }

    private void start() {
        RandomNumberSelectionStrategy computerStrategy = new RandomNumberSelectionStrategy();
        Numbers computerNumbers = Numbers.createNumbersFrom(computerStrategy);
        GameResult result;
        do {
            UserInputNumberSelectionStrategy playerStrategy = new UserInputNumberSelectionStrategy(
                    InputView.inputPlayerNumbers());
            Numbers playerNumbers = Numbers.createNumbersFrom(playerStrategy);
            result = computerNumbers.calculateResult(playerNumbers);
            new HintView(result).printHint();
        } while (!result.isThreeStrikes());
        MessageView.printEndMessage();
    }

    private boolean askRestartOrExit() {
        String answer = InputView.promptContinueGame();
        if (answer.equals(RETRY)) {
            return true;
        }
        if (answer.equals(END_GAME)) {
            return false;
        }
        throw new IllegalArgumentException(INVALID_INPUT_MESSAGE);
    }
}