package baseball;

import java.util.List;

public class BaseballGame {
    private Player player;
    private Computer computer;

    BaseballGame() {
        player = new Player();
        computer = new Computer();
    }

    public void play() {
        computer.pickRandomNumber(3);
        while (true) {
            List<Integer> playerNumbers = player.readNumber();
            GameResult currentResult = computer.getResult(playerNumbers);
            printResult(currentResult);

            if (currentResult.getStrikeCount() == 3 && replay()) {

            }
        }
    }

    private void printResult(GameResult result) {

    }

    private boolean replay() {
        return true;
    }
}
