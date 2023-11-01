package racingcar.service;

import static racingcar.constants.MessageUtils.GAME_WINNER_MSG;
import static racingcar.utils.GameValidator.validateCheckDuplicateCarName;
import static racingcar.utils.GameValidator.validateLastWordToCarName;

import java.util.Arrays;
import racingcar.domain.Car;
import racingcar.domain.RaceCar;
import racingcar.view.InputView;

public class RaceService {

    private final RaceCar raceCar;

    public RaceService(InputView inputView) {
        this.raceCar = new RaceCar();
        addRacingCarsFromInput(inputView.racingCarName(inputView.commonFromInput()));
        validateCheckDuplicateCarName(raceCar.getSavedCar());
    }

    public void start() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Car car : raceCar.getSavedCar()) {
            String carName = car.getCarName();
            String carValue = car.getCarValue();
            stringBuilder.append(carName).append(" : ").append(carValue).append("\n");
        }
        System.out.println(stringBuilder.toString());
    }

    public void addRacingCarsFromInput(String inputName) {
        validateLastWordToCarName(inputName);
        Arrays.stream(inputName.split(","))
                .forEach(name -> raceCar.addSaveCar(new Car(name)));
    }

    public void getWinner() {
        System.out.println(
                GAME_WINNER_MSG.getMessage() + raceCar.findWinner(raceCar.findWinnerNumber())
        );
    }
}
