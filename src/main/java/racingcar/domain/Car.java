package racingcar.domain;

import racingcar.domain.numbergenerator.NumberGenerator;

public class Car implements Comparable<Car>{
    private final String name;
    private final Engine engine;
    private int position;

    public Car(String name, NumberGenerator numberGenerator) throws IllegalArgumentException {
        validateName(name);
        this.name = name;
        this.engine = new Engine(numberGenerator);
    }

    public void tryMove() {
        if(engine.canMove()) {
            position += 1;
        }
    }

    @Override
    public int compareTo(Car other) {
        return this.position - other.position;
    }

    public boolean isSamePosition(Car other) {
        return compareTo(other) == 0;
    }

    private void validateName(String name) throws IllegalArgumentException {
        if (name.length() >= 5 || name.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
