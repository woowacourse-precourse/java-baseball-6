package baseball;

import baseball.entity.*;
import baseball.view.InputView;
import baseball.view.OutputView;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        OutputView.printIntro();

        do {
            run(baseballGame());
        } while (requestRestart());
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

    private static BaseballGame baseballGame() {
        return BaseballGame.from(randomBallsGenerator());
    }

    private static BallsGenerator randomBallsGenerator() {
        return () -> {
            List<Integer> randoms = new ArrayList<>();
            while (randoms.size() < Balls.MAX_BALLS_SIZE) {
                int random = Randoms.pickNumberInRange(Ball.MIN_NUMBER_RANGE, Ball.MAX_NUMBER_RANGE);

                if (!randoms.contains(random)) {
                    randoms.add(random);
                }
            }

            return Balls.from(randoms);
        };
    }
}
