package racingcar.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import racingcar.domain.numbergenerator.NumberGenerator;

public class Cars {
    private final String INPUT_NAMES_REGEX = "^[A-Za-z0-9,]*[A-Za-z0-9]$";
    private final List<Car> cars;

    public Cars(String inputNames, NumberGenerator numberGenerator) {
        validateInputNames(inputNames);
        String[] names = inputNames.split(",");
        cars = Arrays.stream(names)
                .map(name -> new Car(name, numberGenerator))
                .collect(Collectors.toList());
    }

    public void allTryMove() {
        cars.forEach(Car::tryMove);
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    private void validateInputNames(String inputNames) {
        if (!inputNames.matches(INPUT_NAMES_REGEX)) {
            throw new IllegalArgumentException();
        }
    }
}
