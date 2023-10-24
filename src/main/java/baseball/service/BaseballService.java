package baseball.service;

import baseball.dto.StrikeBallCount;
import baseball.util.ComputerBallGenerator;
import baseball.util.InputCalculator;
import baseball.util.RestartCalculator;
import baseball.view.InputView;
import baseball.view.OutputView;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class BaseballService {

    public static void gameStart() {

        InputView.getStartMessage();

        do {
            gamePlay();

        } while (gameEnd());

    }


    private static void gamePlay() {

        int[] computerBall = ComputerBallGenerator.generateComputerBall();

        StrikeBallCount strikeBallCount;

        do {
            List<Integer> userInput = InputView.userInputNumber();

            strikeBallCount = InputCalculator.compareComputerBallAndUserInput(computerBall, userInput);

        } while (!OutputView.generateResultMessage(strikeBallCount));


    }

    private static boolean gameEnd() {

        if (RestartCalculator.isRestart()) {
            return true;
        }

        return false;
    }

}
