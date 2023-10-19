package baseball;

import baseball.model.TripleBalls;
import baseball.util.Util;

public class Player {
    private final TripleBalls playerTripleBalls;

    public Player(String inputNumbers) {
        new InputNumberValidator(inputNumbers);
        this.playerTripleBalls = Util.convertToTripleBalls(inputNumbers);
    }

    public TripleBalls getPlayerTripleBalls() {
        return playerTripleBalls;
    }
}
