package baseball;

import java.util.List;

public class BaseballGame {
    private Computer computer;
    private GameView view;

    BaseballGame() {
        computer = new Computer();
        view = new GameView();
    }

    public void play() {
        view.showStartMessage();
        computer.pickRandomNumber();

        while (true) {
            List<Integer> playerNumbers = view.readNumbers();
            GameResult currentResult = computer.getResult(playerNumbers);
            System.out.println(currentResult.toString());

            if (currentResult.isGameOver()) {
                if (!view.askRestart()) {
                    break;
                }
                computer.pickRandomNumber();
            }
        }
    }
}
