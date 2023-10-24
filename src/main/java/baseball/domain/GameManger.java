package baseball.domain;

import baseball.view.GameView;

public class GameManger {
    public GameManger() {
    }

    public void startGame() {
        boolean isProgress = true;
        GameView.printGameStartMessage();

        while (isProgress) {
            Game game = new Game();
            isProgress = game.start();
        }
    }

}
