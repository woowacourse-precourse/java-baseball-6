package baseball.domain.game;

import baseball.domain.generator.RandomNumberGenerator;
import baseball.domain.ball.Balls;
import java.util.List;

public class Game {

    private Balls balls;

    GameStatus gameStatus;

    public Game() {
        init();
    }

    private void init() {
        this.balls = createBalls();
        gameStatus = GameStatus.RUN;
    }

    private Balls createBalls() {
        List<Integer> randomNumbers = RandomNumberGenerator.createRandomNumbers(3, 1, 9);
        return new Balls(randomNumbers);
    }

    public GameResult compareBalls(Balls otherBalls) {
        GameResult gameResult = createGameResult(otherBalls);
        changeGameStatusBy(gameResult);
        return gameResult;
    }
    private GameResult createGameResult(Balls otherBalls) {
        int strike = this.balls.getSamePositionAndSameNumberCount(otherBalls);
        int ball = this.balls.getSameNumberAndOtherPositionCount(otherBalls);
        return new GameResult(strike, ball);
    }
    private void changeGameStatusBy(GameResult gameResult) {
        if (gameResult.hasEndCondition()) {
            gameStatus = GameStatus.STOP;
        }
    }

    public boolean isRun() {
        return GameStatus.isRun(gameStatus);
    }

    public void performCommand(String inputCommand) {
        GameHandlerCommand command = GameHandlerCommand.findCommand(inputCommand);
        if(command == GameHandlerCommand.RESTART) {
            init();
        }
    }
}
