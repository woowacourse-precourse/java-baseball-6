package baseball;

public class Player {
    private final Number playerNumber;

    public Player(String playerInput) {
        this.playerNumber = new Number(playerInput);
    }

    public Number getPlayerNumber() {
        return playerNumber;
    }
}
