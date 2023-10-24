package baseball;

import java.util.List;

public class GameSystem {
    public void playGame() {
        do {
            startGame();
        } while (restartGame());
    }

    private void startGame() {
        Computer computer = new Computer();
        computer.generateNumbers();
        List<Integer> computerNumbers = computer.getNumbers();
    }

    private boolean restartGame() {
        // TO-DO restart game 로직 작성

        return false;
    }
}
