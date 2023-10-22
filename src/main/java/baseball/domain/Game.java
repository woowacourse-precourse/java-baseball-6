package baseball.domain;

public class Game {
    private final Balls computerBalls;
    private boolean gameFinished;

    public Game(Balls computerBalls) {
        this.computerBalls = computerBalls;
        this.gameFinished = false;
    }

    public Balls getComputerBalls() {
        return computerBalls;
    }

    public boolean isGameFinished() {
        return gameFinished;
    }

    public void updateGameState(GameResult gameResult) {
        if (gameResult.isThreeStrike()) {
            gameFinished = !gameFinished;
        }
    }
}
