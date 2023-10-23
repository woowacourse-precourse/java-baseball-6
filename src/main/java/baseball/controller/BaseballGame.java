package baseball.controller;

import baseball.service.Hint;
import baseball.service.Referee;
import baseball.util.InputParser;
import baseball.util.InputValidator;
import baseball.util.RandomNumberGenerator;
import baseball.view.InputView;

import baseball.view.OutputView;
import java.util.List;

public class BaseballGame {

    public static void startBaseballGame() {
        OutputView.printStartMessage();

        do {
            playBaseballGame();
            OutputView.printEndMessage();
        } while (askForRestart());

        OutputView.printCompletelyEndMessage();
    }

    private static void playBaseballGame() {
        List<Integer> computer = RandomNumberGenerator.generateRandomNumberList();

        while (true) {
            List<Integer> user = getUserNumberList();

            int ballCount = Referee.calculateBallCount(computer, user);
            int strikeCount = Referee.calculateStrikeCount(computer, user);

            String hint = Hint.makeHint(ballCount, strikeCount);
            OutputView.printHintMessage(hint);

            if (Referee.isGameFinished(strikeCount)) {
                break;
            }
        }
    }

    private static List<Integer> getUserNumberList() {
        String userNumber = InputView.getUserNumber();
        InputValidator.validateUserNumber(userNumber);

        return InputParser.parseUserNumber(userNumber);
    }

    private static boolean askForRestart() {
        String restartCommand = InputView.getRestartCommand();
        InputValidator.validateRestartCommand(restartCommand);

        return InputParser.parseRestartCommand(restartCommand);
    }

}
