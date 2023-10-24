package baseball.controller;

import static baseball.model.constants.Rule.RESTART_OPTION;

import baseball.model.domain.Computer;
import baseball.model.domain.Player;
import baseball.model.domain.Restart;
import baseball.model.service.ComputerNumbersGenerator;
import baseball.model.service.ComputerNumbersGeneratorImp;
import baseball.model.service.PlayerNumbersValidator;
import baseball.model.service.PlayerNumbersValidatorImp;
import baseball.model.service.RestartOptionValidator;
import baseball.model.service.RestartOptionValidatorImp;
import baseball.utils.NumbersComparator;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballGame {
    private Computer computer;
    private Player player;
    private Restart restart;

    private final ComputerNumbersGenerator computerNumbersGenerator;
    private final PlayerNumbersValidator playerNumbersValidator;
    private final NumbersComparator numberComparator;
    private final RestartOptionValidator restartOptionValidator;

    private BaseballGame(ComputerNumbersGenerator computerNumbersGenerator,
                         PlayerNumbersValidator playerNumbersValidator,
                         NumbersComparator numbersComparator,
                         RestartOptionValidator restartOptionValidator) {
        this.computerNumbersGenerator = computerNumbersGenerator;
        this.playerNumbersValidator = playerNumbersValidator;
        this.numberComparator = numbersComparator;
        this.restartOptionValidator = restartOptionValidator;
    }

    public static BaseballGame create() {
        return new BaseballGame(
                new ComputerNumbersGeneratorImp(),
                new PlayerNumbersValidatorImp(),
                new NumbersComparator(),
                new RestartOptionValidatorImp()
        );
    }

    public void startGame() {
        OutputView.printGameStart();
        do {
            playGame();
        } while (isRestart());
    }

    private void playGame() {
        initializeGame();
        do {
            getNumbersFromPlayer();
            printHint(getCompareResult());
        } while (isContinue());
        OutputView.printGameClear();
        getRestartOptionFromPlayer();
    }

    private void initializeGame() {
        computer = Computer.from(computerNumbersGenerator);
        player = null;
        restart = null;
    }

    private void getNumbersFromPlayer() {
        player = Player.of(InputView.setGameInput(), playerNumbersValidator);
    }

    private int[] getCompareResult() {
        return numberComparator.getCompareNumberResult(computer.getComputerNumbers(), player.getPlayerNumbers());
    }

    private void printHint(int[] count) {
        printBallCount(count);
        printStrikeCount(count);
        printNothing(count);
    }

    private void printBallCount(int[] count) {
        if (count[0] != 0 && count[1] != 0) {
            OutputView.printCount(count[0]);
            OutputView.printBallStrike();
        }
        if (count[0] != 0 && count[1] == 0) {
            OutputView.printCount(count[0]);
            OutputView.printBall();
        }
    }

    private void printStrikeCount(int[] count) {
        if (count[1] != 0) {
            OutputView.printCount(count[1]);
            OutputView.printStrike();
        }
    }

    private void printNothing(int[] count) {
        if (count[0] == 0 && count[1] == 0) {
            OutputView.printNothing();
        }
    }

    private boolean isContinue() {
        return !numberComparator.isCorrect();
    }

    private void getRestartOptionFromPlayer() {
        restart = Restart.of(InputView.setRestartInput(), restartOptionValidator);
    }

    private boolean isRestart() {
        return restart.getRestartOption().equals(RESTART_OPTION.getValue());
    }
}
