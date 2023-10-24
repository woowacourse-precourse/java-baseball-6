package baseball.controller;

import static baseball.enums.GameMessage.EXIT_GAME_MESSAGE;
import static baseball.enums.GameMessage.INPUT_NUMBERS_MESSAGE;

import baseball.model.input.NumberInput;
import baseball.model.numbers.GameNumbers;
import baseball.model.score.Score;
import baseball.model.score.ScoreCalculator;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballGame {
    private final GameNumbers answer;
    private boolean isRunning;

    public BaseballGame(GameNumbers answer) {
        this.answer = answer;
        isRunning = true;
    }

    public void runGame() {
        while (isRunning) {
            OutputView.print(INPUT_NUMBERS_MESSAGE.getMessage());
            NumberInput input = readInput();

            GameNumbers playerNumbers = new GameNumbers(input.parseInputToIntegerList());

            Score score = ScoreCalculator.calculateScore(playerNumbers, answer);
            OutputView.printScore(score.getBall(), score.getStrike());
            checkThreeStrike(score);
        }
        OutputView.println(EXIT_GAME_MESSAGE.getMessage());
    }

    private NumberInput readInput() {
        String line = InputView.readLine();
        return new NumberInput(line);
    }

    private void checkThreeStrike(Score score) {
        if (score.isThreeStrike()) {
            isRunning = false;
        }
    }
}
