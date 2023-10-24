package baseball.baseballV1.model;

import baseball.baseballV1.util.InputNumberValidator;
import baseball.baseballV1.util.Util;

public class Player {
    private final TripleBalls playerTripleBalls;

    public Player(String inputNumbers) {
        new InputNumberValidator(inputNumbers);
        this.playerTripleBalls = Util.convertStringToTripleBalls(inputNumbers);
    }

    public boolean hasSameBalls(TripleBalls registeredComputer) {
        return playerTripleBalls.hasThreeStrikes(registeredComputer);
    }

    public TripleBalls getPlayerTripleBalls() {
        return playerTripleBalls;
    }
}
