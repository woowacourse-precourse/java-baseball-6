package racingcar.domain;

import racingcar.domain.numbergenerator.NumberGenerator;

public class Car implements Comparable<Car>{
    private static final int MOVE_AMOUNT = 1;
    private final CarName name;
    private final Engine engine;
    private int position;

    public Car(String nameValue, NumberGenerator numberGenerator) throws IllegalArgumentException {
        this.name = new CarName(nameValue);
        this.engine = new Engine(numberGenerator);
    }

    public void tryMove() {
        if(engine.canMove()) {
            position += MOVE_AMOUNT;
        }
    }

    @Override
    public int compareTo(Car other) {
        return Integer.compare(this.position, other.position);
    }

    public boolean isSamePosition(Car other) {
        return compareTo(other) == 0;
    }

    public String getName() {
        return name.getValue();
    }

    public int getPosition() {
        return position;
    }
}
