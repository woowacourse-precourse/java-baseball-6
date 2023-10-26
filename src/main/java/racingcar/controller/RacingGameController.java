package racingcar.controller;

import static racingcar.ui.OutputView.printInputAttemptMessage;
import static racingcar.ui.OutputView.printInputCarNamesMessage;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.RacingCar;
import racingcar.ui.InputView;

public class RacingGameController {

    List<RacingCar> racingCars = new ArrayList<>();
    int attempt;

    public RacingGameController() {
        printInputCarNamesMessage();
        List<String> nameList = InputView.inputCarNames();
        printInputAttemptMessage();
        this.attempt = InputView.inputAttempt();
        for (String name: nameList) {
            racingCars.add(new RacingCar(name));
        }
    }
    public void start() {
        while (attempt-- > 0) {
            for(RacingCar racingCar: racingCars) {
                racingCar.moveRandom();
            }
        }

    }
}
