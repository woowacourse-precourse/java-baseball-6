package baseball.model;

import baseball.validator.ValidatePlayerNumber;

public class Player {

    private final PlayerNumber playerNumber;

    public Player(String numbers) {
        ValidatePlayerNumber.validate(numbers);
        this.playerNumber = new PlayerNumber(numbers);
    }

}
