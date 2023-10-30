package racingcar.domain;

import java.util.*;
import java.util.stream.Collectors;
import javax.management.monitor.StringMonitor;
import racingcar.domain.numbergenerator.NumberGenerator;

public class RacingManager {
    private static final int MIN_ATTEMPT = 1;
    private final Cars cars;
    private int attempts;

    public RacingManager(String inputNames, int attempts, NumberGenerator numberGenerator) {
        validateAttempts(attempts);
        this.cars = new Cars(inputNames, numberGenerator);
        this.attempts = attempts;
    }

    public void doAttempt() {
        cars.allTryMove();
        attempts--;
    }

    public Map<String, Integer> getAttemptResult() {
        Map<String, Integer> attemptsResult = new LinkedHashMap<>();
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
        Car firstCarPosition = cars.getCars().stream()
                .max(Car::compareTo)
                .get();

        return cars.getCars().stream()
                .filter(car -> car.isSamePosition(firstCarPosition))
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private void validateAttempts(int attempts) throws IllegalArgumentException {
        if (attempts < MIN_ATTEMPT) {
            throw new IllegalArgumentException();
        }
    }
}
