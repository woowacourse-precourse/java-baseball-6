package baseball.model;

import static baseball.model.enums.GameMessage.EXIT_GAME;
import static baseball.model.enums.GameMessage.INPUT_NUMBERS;

import baseball.controller.AnswerGenerator;
import baseball.controller.ScoreCalculator;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;

public class Game {
    private final AnswerGenerator answerGenerator;
    private final ScoreCalculator scoreCalculator;
    private final GameNumbers answer;
    private boolean isRunning;

    public Game(AnswerGenerator answerGenerator, ScoreCalculator scoreCalculator) {
        this.answerGenerator = answerGenerator;
        this.scoreCalculator = scoreCalculator;
        this.answer = this.answerGenerator.generateAnswer();
        isRunning = false;
    }

    public void runGame() {
        while (isRunning) {
            OutputView.print(INPUT_NUMBERS.getMessage());
            NumberInput input = readInput();

            GameNumbers playerNumbers = new GameNumbers(input.parseInputToIntegerList());

            Score score = scoreCalculator.calculateScore(playerNumbers, answer);
            OutputView.println(score.toString());
            checkThreeStrike(score);
        }
        OutputView.println(EXIT_GAME.getMessage());
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
