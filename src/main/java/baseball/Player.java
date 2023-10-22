package baseball;

public class Player {

    private Number playerNumbers;

    private Player(Number playerNumbers) {
        this.playerNumbers = playerNumbers;
    }

    public Number getPlayerNumbers() {
        return playerNumbers;
    }

    public static Player from(String input) {
        Number playerNumbers = Number.from(input);
        return new Player(playerNumbers);
    }
}
