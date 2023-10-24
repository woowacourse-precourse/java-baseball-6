package baseball.service;

import baseball.dto.StrikeBallCount;
import baseball.util.ComputerBallGenerator;
import baseball.util.InputCalculator;
import baseball.view.InputView;
import baseball.view.OutputView;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class BaseballService {

    public static void gameStart() {

        InputView.getStartMessage();

        gamePlay();

    }


    private static void gamePlay() {

        int[] computerBall = ComputerBallGenerator.generateComputerBall();

        boolean isCorrect = false;

        do {
            List<Integer> userInput = InputView.userInputNumber();

            StrikeBallCount strikeBallCount = InputCalculator.compareComputerBallAndUserInput(computerBall, userInput);

            isCorrect = OutputView.generateResultMessage(strikeBallCount);

        } while (!isCorrect);


    }

    private static boolean gameEnd() {

        return false;
    }

}
