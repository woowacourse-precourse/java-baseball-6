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
            gameState = gameState.end();
        }
        return playResult;
    }

    public boolean isGameEnd() {
        return gameState.isEnd();
    }

    public void restart() {
        validateGameState();

        initializeData();
    }

    private void validateGameState() {
        if (gameState.isPlaying()) {
            throw new IllegalArgumentException("게임이 종료되지 않은 상태에서 게임을 다시 시작할 수 없습니다.");
        }
    }
}
