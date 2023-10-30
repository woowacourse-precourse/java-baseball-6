package racingcar.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import racingcar.domain.numbergenerator.NumberGenerator;

public class Cars {
    private final List<Car> cars;

    public Cars(List<CarName> carNames, NumberGenerator numberGenerator) {
        cars = carNames.stream()
                .map(name -> new Car(name, numberGenerator))
                .collect(Collectors.toList());
    }

    public Cars(String inputNames, NumberGenerator numberGenerator) {
        this(CarName.parseFrom(inputNames), numberGenerator);
    }

    public void allTryMove() {
        cars.forEach(Car::tryMove);
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }
}
