package baseball.domain;

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
        //System.out.println(randomNumbers);
        return new Balls(randomNumbers);
    }

    public GameResult compareBalls(Balls otherBalls) {
        GameResult gameResult = createGameResult(otherBalls);
        checkResult(gameResult);
        return gameResult;
    }
    private GameResult createGameResult(Balls otherBalls) {
        int strike = this.balls.getSamePositionAndSameNumberCount(otherBalls);
        int ball = this.balls.getOtherPositionAndSameNumberCount(otherBalls);
        return new GameResult(strike, ball);
    }
    private void checkResult(GameResult gameResult) {
        if (gameResult.getStrike() == 3) {
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
