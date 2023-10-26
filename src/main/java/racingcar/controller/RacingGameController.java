package racingcar.controller;

import static racingcar.domain.GameResultAnalyzer.findWinners;
import static racingcar.ui.OutputView.*;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.RacingCar;
import racingcar.ui.InputView;

public class RacingGameController {
    List<RacingCar> racingCars = new ArrayList<>();
    int attempt;

    public void start() {
        initGame();
        raceFor(attempt);
        displayGameResults();
    }

    private void raceFor(int attempt) {
        printAttemptResultMessage();
        do {
            race();
        } while (attempt-- >= 0);
    }

    private void initGame() {
        List<String> nameList = InputView.inputCarNames();
        initRacingCars(nameList);
        this.attempt = InputView.inputAttempt();
    }

    private void initRacingCars(List<String> nameList) {
        for (String name: nameList) {
            racingCars.add(new RacingCar(name));
        }
    }

    private void race() {
        for (RacingCar racingCar : racingCars) {
            racingCar.moveRandom();
        }
        printAttemptResult(racingCars);
    }

    private void displayGameResults() {
        List<RacingCar> winners = findWinners(racingCars);
        printGameResult(winners);
    }
}
