package racingcar.domain;

import racingcar.domain.numbergenerator.NumberGenerator;

public class Car implements Comparable<Car>{
    private static final int MOVE_AMOUNT = 1;
    private static final int NAME_MAX_LENGTH = 4;
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
            position += MOVE_AMOUNT;
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
        if (name.length() > NAME_MAX_LENGTH || name.isEmpty()) {
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
