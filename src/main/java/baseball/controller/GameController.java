package baseball.controller;

import baseball.domain.Ball;
import baseball.domain.Balls;
import baseball.domain.BallsGenerator;
import baseball.domain.BaseballGame;
import baseball.domain.Game;
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
    private Game baseballGame;

    public GameController(Game baseballGame) {
        this.baseballGame = baseballGame;
    }

    public void start() {
        outputView.printStart();
        run();
    }

    private void run() {
        do {
            baseballGame = initGame();
            playGame();
            Retry retry = inputView.scanRetry();
            retryOrEndGame(retry);
        } while (!baseballGame.isEnd());
    }

    private void retryOrEndGame(Retry retry) {
        baseballGame.retryOrEnd(retry);
    }

    private BaseballGame initGame() {
        Balls answerBalls = generateAnswerBalls();
        return baseballGame.init(answerBalls);
    }

    private void playGame() {
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
        return randomBallsGenerator.generateBalls();
    }
}
