package racingcar.domain;

import java.util.*;
import java.util.stream.Collectors;
import javax.management.monitor.StringMonitor;
import racingcar.domain.numbergenerator.NumberGenerator;

public class RacingManager {
    private final Cars cars;
    private int attempts;

    public RacingManager(String inputNames, int attempts, NumberGenerator numberGenerator) {
        validateAttempts(attempts);
        this.cars = new Cars(inputNames, numberGenerator);
        this.attempts = attempts;
    }

    public void doAttempt() {
        cars.allTryMove();
        attempts -= 1;
    }

    public Map<String, Integer> getAttemptResult() {
        Map<String, Integer> attemptsResult = new HashMap<>();
        List<Car> carList = cars.getCars();
        for(Car car: carList) {
            attemptsResult.put(car.getName(), car.getPosition());
        }
        return attemptsResult;
    }

    public boolean isRaceEnd() {
        return attempts == 0;
    }

    public List<String> getWinners() {
        Car headCar = cars.getCars().stream()
                .max(Car::compareTo)
                .get();

        return cars.getCars().stream()
                .filter(car -> car.isSamePosition(headCar))
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private void validateAttempts(int attempts) throws IllegalArgumentException {
        if (attempts < 1) {
            throw new IllegalArgumentException();
        }
    }
}
