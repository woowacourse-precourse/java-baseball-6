package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class GameResultAnalyzer {
    public static List<RacingCar> findWinners(List<RacingCar> racingCars) {
        int maxLocation = racingCars.stream()
                .mapToInt(RacingCar::getLocation)
                .max()
                .orElse(0);

        return racingCars.stream()
                .filter(racingCar -> racingCar.getLocation() == maxLocation)
                .collect(Collectors.toList());
    }
}
