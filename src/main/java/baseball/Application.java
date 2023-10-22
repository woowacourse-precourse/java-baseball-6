package baseball;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        boolean progress = true;
        Computer computer = new Computer();
        Player player = new Player();
        while (progress) {
            boolean gameProgress = true;
            computer.gameStartPhrase();
            List<Integer> computerNums = computer.generateNumber();
            while (gameProgress) {
                computer.inputNumberPhrase();
                List<Integer> playerNums = player.inputNumbers();
            }
        }

    }
}
