package baseball.controller;

import baseball.model.domain.Computer;
import baseball.model.domain.Player;
import baseball.model.domain.Restart;
import baseball.model.service.Generator;
import baseball.model.service.GeneratorImp;
import baseball.model.service.Validator;
import baseball.model.service.ValidatorImp;
import baseball.utils.Comparator;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.List;

public class BaseballGame {
    private Computer computer;
    private Player player;
    private Restart restart;

    private boolean again;
    private boolean correct;

    private final Generator generator;
    private final Validator validator;
    private final Comparator comparator;

    private BaseballGame(Generator generator, Validator validator, Comparator comparator) {
        this.generator = generator;
        this.validator = validator;
        this.comparator = comparator;
    }

    public static BaseballGame create() {
        return new BaseballGame(new GeneratorImp(), new ValidatorImp(), new Comparator());
    }

    public void startGame() {
        OutputView.printGameStart();
        do {
            playGame();
            again = restart.isRestartOption();
        } while (again);
    }

    private void playGame() {
        initializeGame();
        do {
            getNumbersFromPlayer();
            printHint(getCompareResult());
            correct = comparator.isCorrect();
        } while (!correct);
        OutputView.printGameClear();
        getRestartOptionFromPlayer();
    }

    private void initializeGame() {
        computer = Computer.from(generator);
        player = null;
        restart = null;
    }

    private void getNumbersFromPlayer() {
        player = Player.of(InputView.setGameInput(), validator);
    }

    private List<Integer> getCompareResult() {
        return comparator.getCompareNumberResult(computer.getComputerNumbers(), player.getPlayerNumbers());
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

    private void getRestartOptionFromPlayer() {
        restart = Restart.of(InputView.setRestartInput(), validator);
    }
}
