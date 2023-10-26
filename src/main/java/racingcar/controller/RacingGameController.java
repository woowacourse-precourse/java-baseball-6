package racingcar.controller;

import static racingcar.domain.GameResultAnalyzer.findWinners;
import static racingcar.ui.OutputView.*;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.RacingCar;
import racingcar.exception.InvalidInputException;
import racingcar.ui.InputView;

public class RacingGameController {
    List<RacingCar> racingCars = new ArrayList<>();
    int attempt;

    public void start() {
        try {
            initGame();
        } catch (InvalidInputException e) {
            System.out.println(e.getMessage());
            throw new InvalidInputException();
        }
        raceFor(attempt);
        displayGameResults();
    }

    private void initGame() throws InvalidInputException {
        List<String> nameList = InputView.inputCarNames();
        initRacingCars(nameList);
        this.attempt = InputView.inputAttempt();
    }

    private void initRacingCars(List<String> nameList) {
        for (String name: nameList) {
            racingCars.add(new RacingCar(name));
        }
    }

    private void raceFor(int attempt) {
        printAttemptResultMessage();
        while (attempt-- > 0) {
            race();
        }
    }

    private void race() {
        racingCars.forEach(RacingCar::moveRandom);
        printAttemptResult(racingCars);
    }

    private void displayGameResults() {
        List<RacingCar> winners = findWinners(racingCars);
        printGameResult(winners);
    }
}
