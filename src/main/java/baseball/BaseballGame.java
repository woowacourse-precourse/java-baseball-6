package baseball;

import java.util.List;

public class BaseballGame {
    private Computer computer;
    private GameView view;

    BaseballGame() {
        computer = new Computer();
        view = new GameView();
    }

    public void play(int count) {
        view.showStartMessage();
        computer.pickRandomNumber(count);
        GameResult currentResult;
        do {
            List<Integer> playerNumbers = view.readNumbers();
            currentResult = computer.getResult(playerNumbers);
            view.showCurrentResult(currentResult.toString());
        } while(!currentResult.isGameOver() || restart(count));
    }

    private boolean restart(int count) {
        if (view.askRestart()) {
            computer.pickRandomNumber(count);
            return true;
        }
        return false;
    }
}
