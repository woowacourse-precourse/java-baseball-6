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

        do {
            run(baseballGame());
        } while (requestRestart());
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

        OutputView.printOutro(Balls.MAX_BALLS_SIZE);
    }

    private static boolean requestRestart() {
        String playerCommand = InputView.readPlayerCommand(GameCommand.RESTART.getValue(), GameCommand.END.getValue());
        GameCommand command = GameCommand.from(InputMapper.mapToInt(playerCommand));

        return command.isRestart();
    }
}
