package baseball;

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
