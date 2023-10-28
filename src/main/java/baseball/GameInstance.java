package baseball;

public class GameInstance implements IGame {
    private BaseballGame currentGame;

    @Override
    public void startGame() {
        if (currentGame == null) {
            instantiateNewGame();
        }
        currentGame.startGame();
    }

    @Override
    public void restartGame() {
        instantiateNewGame();
    }

    @Override
    public void endGame() {
        if (currentGame != null) {
            currentGame.endGame();
            currentGame = null;
        }
    }

    private void instantiateNewGame() {
        currentGame = new BaseballGame();
    }
}