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
import java.util.List;

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
        } while (!isFinish());
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

    private List<Integer> getCompareResult() {
        return numberComparator.getCompareNumberResult(computer.getComputerNumbers(), player.getPlayerNumbers());
    }

    private void printHint(List<Integer> count) {
        int ball = count.get(0);
        int strike = count.get(1);
        printBallCount(ball, strike);
        printStrikeCount(strike);
        printNothing(ball, strike);
    }

    private void printBallCount(int ball, int strike) {
        if (ball != 0 && strike != 0) {
            OutputView.printCount(ball);
            OutputView.printBallStrike();
        }
        if (ball != 0 && strike == 0) {
            OutputView.printCount(ball);
            OutputView.printBall();
        }
    }

    private void printStrikeCount(int strike) {
        if (strike != 0) {
            OutputView.printCount(strike);
            OutputView.printStrike();
        }
    }

    private void printNothing(int ball, int strike) {
        if (ball == 0 && strike == 0) {
            OutputView.printNothing();
        }
    }

    private boolean isFinish() {
        return numberComparator.isCorrect();
    }

    private void getRestartOptionFromPlayer() {
        restart = Restart.of(InputView.setRestartInput(), restartOptionValidator);
    }

    private boolean isRestart() {
        return restart.getRestartOption().equals(RESTART_OPTION.getValue());
    }
}
