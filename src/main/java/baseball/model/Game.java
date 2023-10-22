package baseball.model;

import static baseball.model.enums.GameMessage.EXIT_GAME_MESSAGE;
import static baseball.model.enums.GameMessage.INPUT_NUMBERS_MESSAGE;

import baseball.controller.ScoreCalculator;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Game {
    private final ScoreCalculator scoreCalculator;
    private final GameNumbers answer;
    private boolean isRunning;

    public Game(GameNumbers answer, ScoreCalculator scoreCalculator) {
        this.scoreCalculator = scoreCalculator;
        this.answer = answer;
        isRunning = false;
    }

    public void runGame() {
        while (isRunning) {
            OutputView.print(INPUT_NUMBERS_MESSAGE.getMessage());
            NumberInput input = readInput();

            GameNumbers playerNumbers = new GameNumbers(input.parseInputToIntegerList());

            Score score = scoreCalculator.calculateScore(playerNumbers, answer);
            OutputView.println(score.toString());
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
