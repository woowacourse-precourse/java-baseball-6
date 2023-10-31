package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RaceCar {

    private final List<Car> cars;

    public RaceCar() {
        this.cars = new ArrayList<>();
    }

    public List<Car> getSavedCar() {
        return cars;
    }

    public void addSaveCar(Car car) {
        cars.add(car);
    }

    public int findWinnerNumber() {
        return cars.stream()
                .mapToInt(Car::getForwardCount)
                .max()
                .orElse(0);
    }

    public String findWinner(int winnerCount) {
        return cars.stream()
                .filter(car -> car.getForwardCount() >= winnerCount)
                .map(Car::getCarName)
                .collect(Collectors.joining(", "));
    }
}
