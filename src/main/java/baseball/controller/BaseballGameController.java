package baseball.controller;

import baseball.model.Computer;
import baseball.model.Player;
import baseball.model.Referee;
import baseball.util.InputValidator;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;

public class BaseballGameController {
    private final static String RESTART = "1";
    private final static String END = "2";
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
        computer.setComputerNumber();
        List<Integer> computerNumber = computer.getComputerNumber();
        while (continueGame) {
            String playerNumberAsString = InputView.inputNumber();
            isValidPlayerNumber(playerNumberAsString);
            player.setPlayerNumber(playerNumberAsString);
            List<Integer> playerNumber = player.getPlayerNumber();

            boolean success = referee.compareComputerPlayer(computerNumber, playerNumber);
            if (success) {
                isSuccess();
            }
            if (!success) {
                int ball = referee.calculateBall(computerNumber, playerNumber);
                int strike = referee.calculateStrike(computerNumber, playerNumber);
                printHint(ball, strike);
            }
        }
    }

    private void isSuccess() {
        OutputView.printSuccess();
        String restartOrEndNumber = InputView.restartOrEndNumber();
        isValidRestartOrEndNumber(restartOrEndNumber);

        if (restartOrEndNumber.equals(RESTART)) {
            run();
        }
        if (restartOrEndNumber.equals(END)) {
            continueGame = false;
        }
    }

    private void printHint(int ball, int strike) {
        OutputView.printStrikeAndBall(ball, strike);
    }

    private void isValidPlayerNumber(String number) {
        String answerValidationRegex = "^(?!.*(.).*\\1)[1-9]{3}$";
        InputValidator.validateInput(answerValidationRegex, number);
    }

    private void isValidRestartOrEndNumber(String number) {
        String oneOrTwoValidationRegex = "^[12]$";
        InputValidator.validateInput(oneOrTwoValidationRegex, number);
    }
}
