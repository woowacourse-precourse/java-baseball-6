package baseball.controller;

import baseball.domain.Ball;
import baseball.domain.Balls;
import baseball.domain.GameResult;
import baseball.domain.GameStatus;
import baseball.utils.NumberGenerator;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.List;

public class BaseballGameController {
    private final InputView inputView;
    private final OutputView outputView;

    public BaseballGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;

    }

    public void run() {
        outputView.printGameStart();

        GameStatus gameStatus = GameStatus.RESTART;
        while (gameStatus != GameStatus.EXIT) {
            Balls computer = createComputer();

            GameResult gameResult = GameResult.CONTINUE;
            while (gameResult != GameResult.END) {
                Balls player = createPlayer();
                gameResult = getGameResult(computer, player);
            }

            outputView.printGameEnd();
            gameStatus = getGameStatus();
        }
    }

    private Balls createPlayer() {
        int playerNumber = inputView.readPlayerNumber();
        return new Balls(playerNumber);
    }

    private static Balls createComputer() {
        List<Integer> generatedNumbers =
                NumberGenerator.generateUniqueNumbers(Ball.LOWER_LIMIT, Ball.UPPER_LIMIT, Balls.BALLS_SIZE);
        return new Balls(generatedNumbers);
    }

    private GameResult getGameResult(Balls computer, Balls player) {
        GameResult gameResult;
        int ballCount = computer.getBallCount(player);
        int strikeCount = computer.getStrikeCount(player);
        outputView.printBallAndStrike(ballCount, strikeCount);
        gameResult = GameResult.from(strikeCount);
        return gameResult;
    }

    private GameStatus getGameStatus() {
        GameStatus gameStatus;
        int command = inputView.readGameCommand();
        gameStatus = GameStatus.from(command);
        return gameStatus;
    }
}
