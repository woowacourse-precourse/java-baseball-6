package baseball.controller;

import static baseball.model.enums.GameMessage.GAME_START_MESSAGE;
import static baseball.model.enums.GameMessage.INPUT_RESTART_OR_EXIT_MESSAGE;

import baseball.model.numbers.AnswerGenerator;
import baseball.model.numbers.GameNumbers;
import baseball.model.input.RestartOrExitInput;
import baseball.model.score.ScoreCalculator;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {
    private final AnswerGenerator answerGenerator;
    private boolean isRunning;

    public GameController() {
        this.answerGenerator = new AnswerGenerator();
        this.isRunning = true;
    }

    public void start() {
        OutputView.println(GAME_START_MESSAGE.getMessage());
        ScoreCalculator scoreCalculator = new ScoreCalculator();
        while (isRunning) {
            GameNumbers answer = answerGenerator.generateAnswer();
            BaseballGame baseballGame = new BaseballGame(answer, scoreCalculator);

            baseballGame.runGame();

            OutputView.println(INPUT_RESTART_OR_EXIT_MESSAGE.getMessage());
            RestartOrExitInput restartOrExitInput = readInput();
            if (restartOrExitInput.isExitInput()) {
                isRunning = false;
            }
        }
    }

    private RestartOrExitInput readInput() {
        String line = InputView.readLine();
        return new RestartOrExitInput(line);
    }
}
