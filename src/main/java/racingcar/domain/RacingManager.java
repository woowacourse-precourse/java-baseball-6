package racingcar.domain;

import java.util.*;
import java.util.stream.Collectors;
import javax.management.monitor.StringMonitor;
import org.mockito.internal.matchers.Null;
import racingcar.domain.numbergenerator.NumberGenerator;

public class RacingManager {
    private static final String INPUT_NAMES_REGEX = "^[A-Za-z0-9,]*[A-Za-z0-9]$";
    private static final String NAME_DELIMITER = ",";
    private static final int MIN_ATTEMPT = 1;
    private final Cars cars;
    private int attempts;

    public RacingManager(String inputNames, int attempts, NumberGenerator numberGenerator) {
        validateAttempts(attempts);
        validateInputNames(inputNames);

        List<CarName> carNameList = Arrays.stream(inputNames.split(NAME_DELIMITER))
                .map(CarName::new)
                .toList();

        this.cars = new Cars(carNameList, numberGenerator);
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
        Car frontCar = cars.getCars().stream()
                .max(Car::compareTo)
                .orElseThrow(IllegalArgumentException::new);

        return cars.getCars().stream()
                .filter(car -> car.isSamePosition(frontCar))
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    private void validateAttempts(int attempts) throws IllegalArgumentException {
        if (attempts < MIN_ATTEMPT) {
            throw new IllegalArgumentException();
        }
    }

    private void validateInputNames(String inputNames) {
        if (!inputNames.matches(INPUT_NAMES_REGEX)) {
            throw new IllegalArgumentException();
        }
    }
}
