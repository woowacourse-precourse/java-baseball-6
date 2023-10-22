package baseball.controller;

import baseball.model.Computer;
import baseball.model.Player;
import baseball.model.Referee;
import baseball.util.InputValidator;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;

public class BaseballGameController {
    private static final String RESTART = "1";
    private static final String END = "2";
    private boolean firstRun = true;
    private boolean continueGame = true;

    public void run() {
        if (firstRun) {
            OutputView.printStart();
            firstRun = false;
        }
        Computer computer = new Computer();
        Player player = new Player();
        Referee referee = new Referee();
        repeatGame(computer, player, referee);
    }

    private void repeatGame(Computer computer, Player player, Referee referee) {
        computer.createComputerNumber();
        List<Integer> computerNumber = computer.getComputerNumber();
        while (continueGame) {
            String playerNumberAsString = InputView.inputNumber();
            InputValidator.isValidPlayerNumber(playerNumberAsString);
            player.createPlayerNumber(playerNumberAsString);
            List<Integer> playerNumber = player.getPlayerNumber();

            boolean success = referee.compareComputerPlayer(computerNumber, playerNumber);
            if (success) {
                isSuccess();
            }
            if (!success) {
                int ball = referee.calculateBall(computerNumber, playerNumber);
                int strike = referee.calculateStrike(computerNumber, playerNumber);
                OutputView.printStrikeAndBall(ball, strike);
            }
        }
    }

    private void isSuccess() {
        OutputView.printSuccess();
        String restartOrEndNumber = InputView.restartOrEndNumber();
        InputValidator.isValidRestartOrEndNumber(restartOrEndNumber);

        if (restartOrEndNumber.equals(RESTART)) {
            run();
        }
        if (restartOrEndNumber.equals(END)) {
            continueGame = false;
        }
    }
}
