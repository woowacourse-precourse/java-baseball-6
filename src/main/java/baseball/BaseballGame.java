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
        String toString = "";
        if (result.getBallCount() > 0) {
            toString += result.getBallCount() + "볼";
        }
        if (result.getStrikeCount() > 0) {
            toString += result.getStrikeCount() + "스트라이크";
        }
        System.out.println(toString);
    }

    private boolean replay() {
        return true;
    }
}
