package baseball.controller;

import static baseball.enums.Message.INPUT_NUMBER_PROMPT;
import static baseball.enums.Message.START_MESSAGE;

import baseball.model.Score;
import baseball.model.ThreeIntegers;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseBallGameController {
    private final InputView inputView;
    private final OutputView outputView;

    private BaseBallGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public static BaseBallGameController of(InputView inputView, OutputView outputView) {
        return new BaseBallGameController(inputView, outputView);
    }

    public void playGame() {
        outputView.printMessage(START_MESSAGE);
        boolean isGameToBeContinued;
        do {
            ThreeIntegers pickedThreeIntegers = ThreeIntegers.createRandomThreeIntegers();

            playGameFrom(pickedThreeIntegers);
            isGameToBeContinued = inputView.askIfContinue();
        } while (isGameToBeContinued);
        inputView.close();
    }

    private void playGameFrom(ThreeIntegers pickedThreeIntegers) {
        while (true) {
            outputView.printMessage(INPUT_NUMBER_PROMPT);

            String inputValue = inputView.getInputValue();
            Score score = pickedThreeIntegers.calculateScoreFrom(inputValue);

            outputView.printScoreBoardMessageFrom(score);
            outputView.printIfStrikeOutFrom(score);

            if (score.isStrikeOut()) {
                break;
            }
        }
    }
}
