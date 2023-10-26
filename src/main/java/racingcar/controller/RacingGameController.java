package racingcar.controller;

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
        printAttemptResultMessage();
        while (attempt-- > 0) {
            race();
        }
        gameEndResult();
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

    private void gameEndResult() {
        List<RacingCar> winners = new ArrayList<>();
        int maxLocation = 0;
        for(RacingCar racingCar: racingCars) {
            if (racingCar.getLocation() > maxLocation) {
                maxLocation = racingCar.getLocation();
            }
        }

        for(RacingCar racingCar: racingCars) {
            if (racingCar.getLocation() == maxLocation) {
                winners.add(racingCar);
            }
        }

        printGameResult(winners);
    }
}
