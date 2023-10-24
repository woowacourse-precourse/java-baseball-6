package baseball.controller;

import baseball.application.NumberGenerator;
import baseball.domain.GameResult;
import baseball.domain.Numbers;
import baseball.view.InputView;
import baseball.view.ResultView;

import static baseball.controller.InputCommand.EXIT_COMMAND;
import static baseball.controller.InputCommand.RESTART_COMMAND;

public class BaseballGame {

    private final NumberGenerator numberGenerator;

    public void gameStart() {
        do {
            Numbers otherNumbers = numberGenerator.generateNumbers();

            playRound(otherNumbers);
        }
        while (checkNextGame());
    }

    private static void playRound(Numbers otherNumbers) {
        while (true) {
            Numbers numbers = InputView.readUserNumbers();

            GameResult gameResult = numbers.compareWith(otherNumbers);

            ResultView.showResult(gameResult);

            if (gameResult.isStrikeOut()) {
                break;
            }
        }
    }

    private boolean checkNextGame() {
        String command = InputView.readRestartOrExit();

        if (command.equals(EXIT_COMMAND.getValue())) {
            return false;
        } else if (command.equals(RESTART_COMMAND.getValue())) {
            return true;
        } else {
            throw new IllegalArgumentException("1 또는 2를 입력해주세요.");
        }
    }

    public BaseballGame(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }
}
