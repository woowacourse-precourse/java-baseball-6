package baseball.model;

import java.util.List;

public class Game {

    private final Computer computer;
    private final Player player;

    public Game(Computer computer, Player player) {
        this.computer = computer;
        this.player = player;
    }

    public GameResult playGame(){
        List<Integer> playerNumber = player.getPlayerNumber();
        List<Integer> computerNumber = computer.getComputerNumber();

        int strikes = 0;
        int balls = 0;

        for (int i = 0; i < 3; i++) {
            if (playerNumber.get(i).equals(computerNumber.get(i))) {
                strikes++;
            } else if (computerNumber.contains(playerNumber.get(i))) {
                balls++;
            }
        }
      return new GameResult(balls, strikes);
    }

}
