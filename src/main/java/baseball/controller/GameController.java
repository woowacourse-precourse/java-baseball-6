package baseball.controller;

import baseball.domain.Ball;
import baseball.domain.Balls;
import baseball.domain.BallsGenerator;
import baseball.domain.BaseballGame;
import baseball.domain.GameResult;
import baseball.domain.NumberGenerator;
import baseball.domain.RandomBallsGenerator;
import baseball.domain.RandomNumberGenerator;
import baseball.domain.Retry;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.List;

public class GameController {

    private final InputView inputView = InputView.getInstance();
    private final OutputView outputView = OutputView.getInstance();

    public void start() {
        outputView.printStart();
        run();
    }

    private void run() {
        BaseballGame baseballGame;
        do {
            baseballGame = initGame();
            playGame(baseballGame);
            Retry retry = inputView.scanRetry();
            retryGame(baseballGame, retry);
        } while (!baseballGame.isEnd());
    }

    private void retryGame(BaseballGame baseballGame, Retry retry) {
        baseballGame.retry(retry);
    }

    private BaseballGame initGame() {
        Balls answerBalls = generateAnswerBalls();
        return BaseballGame.init(answerBalls);
    }

    private void playGame(BaseballGame baseballGame) {
        while (baseballGame.isPlaying()) {
            Balls playerBalls = inputView.scanBalls();
            GameResult gameResult = baseballGame.getTryResultList(playerBalls);
            outputView.printResult(gameResult);
            baseballGame.checkGameWin(gameResult);
        }
        outputView.printGameOver();
    }

    private Balls generateAnswerBalls() {
        NumberGenerator numberGenerator = RandomNumberGenerator.init();
        BallsGenerator randomBallsGenerator = RandomBallsGenerator.init(numberGenerator);
        List<Ball> answerBalls = randomBallsGenerator.generateBalls();
        return Balls.from(answerBalls);
    }
}
