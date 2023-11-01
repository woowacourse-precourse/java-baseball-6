package racingcar;

import racingcar.domain.RacingManager;
import racingcar.domain.CarNameParser;
import racingcar.domain.numbergenerator.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {
    private final RandomNumberGenerator randomNumberGenerator;
    private final InputView inputView;
    private final OutputView outputView;

    public RacingGameController(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void start(){
        RacingManager racingManager = setUpManager();
        executeGame(racingManager);
        showGameResult(racingManager);
    }

    private RacingManager setUpManager() {
        outputView.printCarNamesInputMessage();
        String carNames = inputView.inputCarNames();
        outputView.printAttemptsInputMessage();
        int attempts = inputView.inputAttempts();
        return new RacingManager(new CarNameParser().parse(carNames), attempts, randomNumberGenerator);
    }

    private void executeGame(RacingManager racingManager) {
        outputView.printAttemptResultStartMessage();
        do {
            racingManager.doAttempt();
            showAttemptResult(racingManager);
        } while (!racingManager.isRaceEnd());
    }

    private void showAttemptResult(RacingManager racingManager) {
        outputView.printAttemptResult(racingManager.getAttemptResult());
    }

    private void showGameResult(RacingManager racingManager) {
        outputView.printGameResult(racingManager.getWinners());
    }
}
