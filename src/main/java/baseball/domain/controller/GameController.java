package baseball.domain.controller;

import baseball.domain.config.GameCommand;
import baseball.domain.entity.ScoreBoard;
import baseball.domain.service.GameService;
import baseball.domain.util.generator.ComputerGenerator;
import baseball.domain.util.generator.UserGenerator;
import baseball.domain.view.input.UserInput;
import baseball.domain.view.output.GameProcessingPrinter;
import java.util.List;

public class GameController {
    private final ScoreBoard END_SCORE_BOARD = ScoreBoard.getEndScoreBoard();

    public void run() {
        GameProcessingPrinter.printGameStart();
        startGame();
    }

    private void startGame() {
        play();
        redoGame();
    }

    private void play() {
        List<Integer> target = ComputerGenerator.getTarget();
        
        attepmtBaseball(target);
        GameProcessingPrinter.printGameEnd();
    }

    private void attepmtBaseball(List<Integer> target) {
        while (true) {
            List<Integer> attempt = UserGenerator.getAttempt();

            ScoreBoard attemptScoreBoard = GameService.gameLogic(attempt, target);

            if (END_SCORE_BOARD.equals(attemptScoreBoard)) {
                break;
            }
        }
    }

    private void redoGame() {
        int option = getOption();
        GameCommand command = GameCommand.from(option);

        if (command.equals(GameCommand.QUIT)) {
            return;
        }

        startGame();
    }

    private static int getOption() {
        String userInput = UserInput.getEndGameInput();
        return UserInput.toInt(userInput);
    }
}
