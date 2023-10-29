package racingcar.domain;

import racingcar.domain.numbergenerator.NumberGenerator;

public class Engine {
    private final int MOVE_CONDITION_MIN_NUMBER = 4;
    private NumberGenerator numberGenerator;
    public Engine(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public boolean canMove() {
        return numberGenerator.generate() >= MOVE_CONDITION_MIN_NUMBER;
    }
}
