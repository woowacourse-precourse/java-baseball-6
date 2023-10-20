package baseball.domain;

import java.util.List;

public class BaseballGame {
    private Balls computerBalls;
    private GameState gameState;

    public BaseballGame() {
        initializeData();
    }

    private void initializeData() {
        this.computerBalls = new Balls(createRandomNumbers());
        this.gameState = GameState.PLAYING;
    }

    protected List<Integer> createRandomNumbers() {
        return RandomNumberGenerator.createRandomNumbers();
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
