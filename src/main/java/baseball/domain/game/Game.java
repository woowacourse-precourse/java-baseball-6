package baseball.domain.game;

import baseball.domain.generator.RandomNumberGenerator;
import baseball.domain.ball.Baseballs;
import java.util.List;

public class Game {

    private Baseballs baseBalls;

    GameStatus gameStatus;

    public Game() {
        init();
    }

    private void init() {
        this.baseBalls = createBalls();
        gameStatus = GameStatus.RUN;
    }

    private Baseballs createBalls() {
        List<Integer> randomNumbers = RandomNumberGenerator.createRandomNumbers(3, 1, 9);
        return new Baseballs(randomNumbers);
    }

    public GameResult compareBalls(Baseballs otherBaseballs) {
        GameResult gameResult = createGameResult(otherBaseballs);
        changeGameStatusBy(gameResult);
        return gameResult;
    }

    private GameResult createGameResult(Baseballs otherBaseballs) {
        int strike = this.baseBalls.getStrikeCount(otherBaseballs);
        int ball = this.baseBalls.getBallCount(otherBaseballs);
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

    public boolean isEnd() {
        return !isRun();
    }

    public void performCommand(String inputCommand) {
        GameHandlerCommand command = GameHandlerCommand.findCommand(inputCommand);
        if (GameHandlerCommand.isRestartCommand(command)) {
            init();
        }
    }


}
