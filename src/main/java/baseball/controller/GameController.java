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
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GameController {

    private final InputView inputView = InputView.getInstance();
    private final OutputView outputView = OutputView.getInstance();

    public void start() {
        outputView.printStart();
        run();
    }

    private void run() {
        Retry retry = Retry.DEFAULT;
        while (!retry.isEnd()) {
            Balls answerBalls = generateAnswerBalls();
            BaseballGame baseballGame = BaseballGame.from(answerBalls);
            play(baseballGame);
            retry = inputView.scanRetry();
        }
    }

    private void play(BaseballGame baseballGame) {
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
        BallsGenerator randomBallsGenerator = RandomBallsGenerator.init();
        List<Ball> answerBalls = randomBallsGenerator.generateBalls(numberGenerator);
        return Balls.from(answerBalls);
    }
}
