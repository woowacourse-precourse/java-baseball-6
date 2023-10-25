package baseball;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        Game game = new Game();
        Judgment judgment = new Judgment();

        game.startGame();
        List<Integer> computerNumbers = game.generateRandomNumber();

        while (true) {
            List<Integer> playerNumbers = game.inputPlayerNumbers();
            int[] counts = judgment.countMatchingNumbers(computerNumbers, playerNumbers);
            judgment.printHint(counts[0], counts[1]);

            if (counts[0] == 3) {
                if (!judgment.askForRestartOrExit()) {
                    break;
                }
                computerNumbers = game.generateRandomNumber();
            }
        }
    }
}
