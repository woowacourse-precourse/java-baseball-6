package baseball.model;

import baseball.validator.ValidatePlayerNumber;
import java.util.ArrayList;
import java.util.List;

public class PlayerNumber {
    private final List<BallNumber> playerNumber;

    public PlayerNumber(String numbers) {
        ValidatePlayerNumber.validate(numbers);
        this.playerNumber = generatePlayerNumber(numbers);
    }

    public List<BallNumber> generatePlayerNumber(String numbers) {
        List<BallNumber> playerNumber = new ArrayList<>();
        for (char number : numbers.toCharArray()) {
            playerNumber.add(new BallNumber(Character.getNumericValue(number)));
        }
        return playerNumber;
    }

    public BallNumber getNumberByPosition(int position) {
        return playerNumber.get(position);
    }

}
