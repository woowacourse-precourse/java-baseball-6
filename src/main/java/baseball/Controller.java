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
        player.printMessage("숫자 야구 게임을 시작합니다.");

        while (true) {
            checker.generateComputerNumbers();
            boolean gameWon = false;

            while (!gameWon) {
                List<Integer> userNumbers = player.getUserInput();
                gameWon = checker.checkGuess(userNumbers);
            }

            int choice = player.getPlayAgainChoice();
            if (choice != 1) {
                player.printMessage("프로그램을 종료합니다.");
                break;
            }
        }
    }

}
