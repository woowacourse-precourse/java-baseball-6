package racingcar.domain;

import static racingcar.constant.CAR_INIT_LOCATION;

import java.util.List;
import java.util.stream.Collectors;

public class GameResultAnalyzer {
    public static List<RacingCar> findWinners(List<RacingCar> racingCars) {
        int maxLocation = racingCars.stream()
                .mapToInt(RacingCar::getLocation)
                .max()
                .orElse(CAR_INIT_LOCATION);

        return racingCars.stream()
                .filter(racingCar -> racingCar.getLocation() == maxLocation)
                .collect(Collectors.toList());
    }
}
