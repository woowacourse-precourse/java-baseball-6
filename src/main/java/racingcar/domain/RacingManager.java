package racingcar.domain;

import java.util.*;
import java.util.stream.Collectors;
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
        cars.getCars().forEach(car -> attemptsResult.put(car.getName(), car.getPosition()));
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
            throw new IllegalArgumentException("[ERROR] 횟수가 1보다 작습니다.");
        }
    }

    private void validateInputNames(String inputNames) {
        if (!inputNames.matches(INPUT_NAMES_REGEX)) {
            throw new IllegalArgumentException("[ERROR] 이름 입력 형식이 맞지 않습니다.");
        }
        List<String> nameList = List.of(inputNames.split(NAME_DELIMITER));
        Set<String> nameSet = new HashSet<>(nameList);
        if (nameList.size() != nameSet.size()) {
            throw new IllegalArgumentException("[ERROR] 이름이 중복됩니다.");
        }
    }
}
