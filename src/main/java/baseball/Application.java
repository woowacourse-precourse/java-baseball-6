package baseball;

import baseball.entity.Balls;
import baseball.entity.BallsGenerator;
import baseball.entity.BaseballGame;
import baseball.entity.PlayResult;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        OutputView.printIntro();

        run(baseballGame());
    }

    private static BaseballGame baseballGame() {
        return BaseballGame.from(ballsGenerator());
    }

    private static BallsGenerator ballsGenerator() {
        return () -> Balls.from(List.of(1, 2, 3));
    }

    private static void run(BaseballGame baseballGame) {
        while (!baseballGame.isEnd()) {
            List<Integer> playerNumbers = InputMapper.mapToInteger(InputView.readPlayerNumbers());

            PlayResult result = baseballGame.play(Balls.from(playerNumbers));

            OutputView.printResult(result);
        }
    }
}
