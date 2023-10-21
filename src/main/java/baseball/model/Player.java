package baseball.model;

public class Player {

    private final PlayerNumber playerNumber;

    public Player(String numbers) {
        this.playerNumber = new PlayerNumber(numbers);
    }

}
