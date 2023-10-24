package baseball.controller;

import baseball.model.input.NumberInput;
import baseball.model.numbers.GameNumbers;
import baseball.model.score.Score;
import baseball.model.score.ScoreCalculator;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballGame {
    private static final String EXIT_GAME_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String INPUT_NUMBERS_MESSAGE = "숫자를 입력해주세요 : ";

    private final GameNumbers answer;
    private boolean isRunning;

    public BaseballGame(GameNumbers answer) {
        this.answer = answer;
        isRunning = true;
    }

    public void runGame() {
        while (isRunning) {
            OutputView.print(INPUT_NUMBERS_MESSAGE);
            NumberInput input = readInput();

            GameNumbers playerNumbers = new GameNumbers(input.parseInputToIntegerList());

            Score score = ScoreCalculator.calculateScore(playerNumbers, answer);
            OutputView.printScore(score.getBall(), score.getStrike());
            checkThreeStrike(score);
        }
        OutputView.println(EXIT_GAME_MESSAGE);
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
