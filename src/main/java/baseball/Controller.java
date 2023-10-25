package baseball;

import java.util.List;

public class Controller {
    private Checker checker;
    private Player player;

    public Controller(Checker checker, Player player) {
        this.checker = checker;
        this.player = player;
    }

    public void startGame() {
        while (true) {
            checker.generateComputerNumbers();
            boolean gameWon = false;

            while (!gameWon) {
                List<Integer> playerNumbers = player.getPlayerInput();
                gameWon = checker.playerInputCheck(playerNumbers);
            }

            int choice = player.getPlayAgainChoice();
            if (choice != 1) {
                System.out.println("게임 종료");
                break;
            }
        }
    }
}
