package baseball.domain;

public class Game {
    private GameState gameState = GameState.READY;
    private BallsGenerator ballsGenerator;
    private Balls standard;

    public Game(BallsGenerator ballsGenerator) {
        this.ballsGenerator = ballsGenerator;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void start() {
        standard = ballsGenerator.generateBalls();
        gameState = GameState.ON;
    }

    public void end() {
        gameState = GameState.OFF;
    }
}
