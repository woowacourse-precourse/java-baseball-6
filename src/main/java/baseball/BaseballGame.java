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
        GameResult currentResult;
        do {
            List<Integer> playerNumbers = view.readNumbers();
            currentResult = computer.getResult(playerNumbers);
            view.showCurrentResult(currentResult.toString());
        } while(!currentResult.isGameOver() || restart());
    }

    private boolean restart() {
        if (view.askRestart()) {
            computer.pickRandomNumber();
            return true;
        }
        return false;
    }
}
