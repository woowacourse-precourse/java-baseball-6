package baseball.model;


import static baseball.model.GameNumbers.createRandomGameNumbers;

public class Game {

    private GameNumbers userGameNumbers;
    private final GameNumbers computerGameNumbers = createRandomGameNumbers();
    private Result result;

    public void updateUserNumbers(GameNumbers userGameNumbers) {
        this.userGameNumbers = userGameNumbers;
    }
}
