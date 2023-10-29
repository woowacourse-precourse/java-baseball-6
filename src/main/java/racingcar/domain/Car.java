package racingcar.domain;

import racingcar.domain.numbergenerator.NumberGenerator;

public class Car implements Comparable<Car>{
    private final String name;
    private final Engine engine;
    private int position;

    public Car(String name, NumberGenerator numberGenerator) {
        validateName(name);
        this.name = name;
        this.engine = new Engine(numberGenerator);
    }

    public void tryMove() {

    }

    @Override
    public int compareTo(Car other) {
        return this.position - other.position;
    }

    public boolean isSamePosition(Car other) {
        return true;
    }

    private void validateName(String name) {

    }
}
