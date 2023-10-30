package racingcar;

import racingcar.domain.RacingManager;
import racingcar.domain.numbergenerator.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {
    private final InputView inputView;
    private final OutputView outputView;
    private RacingManager racingManager;

    public RacingGameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void start(){
        setUpGame();
        playRace();
        printGameResult();
    }

    private void setUpGame() {
        outputView.showCarNamesInputMessage();
        String carNames = inputView.inputCarNames();
        outputView.showAttemptsInputMessage();
        int attempts = inputView.inputAttempts();
        System.out.println(attempts);
        this.racingManager = new RacingManager(carNames, attempts, new RandomNumberGenerator());
    }

    private void playRace() {
        outputView.showAttemptResultStartMessage();
        do {
            racingManager.doAttempt();
            printAttemptResult();
        } while (!racingManager.isRaceEnd());
    }

    private void printAttemptResult() {
        outputView.showAttemptResult(racingManager.getAttemptResult());
    }

    private void printGameResult() {
        outputView.showGameResult(racingManager.getWinners());
    }
}
