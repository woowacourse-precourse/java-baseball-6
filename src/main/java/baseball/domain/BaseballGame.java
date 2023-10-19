package baseball.domain;

public class BaseballGame {
    private Balls computerBalls;
    private GameState gameState;

    public BaseballGame(Balls computerBalls) {
        this.computerBalls = computerBalls;
        this.gameState = GameState.PLAYING;
    }

    public BaseballGame() {
        initializeData();
    }

    private void initializeData() {
        this.computerBalls = new Balls(RandomNumberGenerator.createRandomNumbers());
        this.gameState = GameState.PLAYING;
    }

    public PlayResult play(Balls userBalls) {
        PlayResult playResult = computerBalls.play(userBalls);

        if (playResult.isThreeStrike()) {
            gameState = GameState.END;
        }
        return playResult;
    }

    public boolean isGameEnd() {
        return gameState == GameState.END;
    }

    public void restart() {
        initializeData();
    }
}
