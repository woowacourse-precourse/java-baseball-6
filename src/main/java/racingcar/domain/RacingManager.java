package racingcar.domain;

import java.util.*;
import java.util.stream.Collectors;
import racingcar.domain.numbergenerator.NumberGenerator;

public class RacingManager {
    private final Cars cars;
    private final Attempts attempts;

    public RacingManager(List<CarName> carNames, int attempts, NumberGenerator numberGenerator) {
        this.cars = new Cars(carNames, numberGenerator);
        this.attempts = new Attempts(attempts);
    }

    public void doAttempt() {
        cars.allTryMove();
        attempts.decreaseAttempts();
    }

    public Map<String, Integer> getAttemptResult() {
        Map<String, Integer> attemptsResult = new LinkedHashMap<>();
        cars.getCars().forEach(car -> attemptsResult.put(car.getName(), car.getPosition()));
        return attemptsResult;
    }

    public boolean isRaceEnd() {
        return attempts.isZero();
    }

    public List<String> getWinners() {
        Car frontCar = cars.getCars().stream()
                .max(Car::compareTo)
                .orElseThrow(IllegalArgumentException::new);

        return cars.getCars().stream()
                .filter(car -> car.isSamePosition(frontCar))
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}
