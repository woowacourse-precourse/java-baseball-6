package racingcar.domain;

import racingcar.domain.numbergenerator.NumberGenerator;

public class Car implements Comparable<Car>{
    private static final int MOVE_AMOUNT = 1;
    private final CarName name;
    private final Engine engine;
    private final Position position;

    public Car(CarName name, NumberGenerator numberGenerator) throws IllegalArgumentException {
        this.name = name;
        this.engine = new Engine(numberGenerator);
        this.position = new Position();
    }

    public void tryMove() {
        if(engine.canMove()) {
            position.moveBy(MOVE_AMOUNT);
        }
    }

    @Override
    public int compareTo(Car other) {
        return Integer.compare(this.position.getValue(), other.position.getValue());
    }

    public boolean isSamePosition(Car other) {
        return compareTo(other) == 0;
    }

    public String getName() {
        return name.value();
    }

    public int getPosition() {
        return position.getValue();
    }
}
