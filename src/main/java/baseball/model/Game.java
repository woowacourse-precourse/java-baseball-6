package baseball.model;

import java.util.List;

public class Game {
    private List<Integer> computerNumber;
    private List<Integer> playerNumber;
    private GameResult gameResult;

    public void setComputerNumber() {
        this.computerNumber = new ComputerNumber().getComputerNumber();
    }

    public void setPlayerNumber(String input) {
        this.playerNumber = new PlayerNumber(input).getPlayerNumber();
    }

    public GameResult getGameResult() {
        return this.gameResult = new GameResult(computerNumber, playerNumber);
    }
}
