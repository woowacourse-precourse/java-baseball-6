package baseball.service;

import baseball.util.ComputerBallGenerator;
import baseball.util.InputCalculator;
import baseball.view.InputView;
import camp.nextstep.edu.missionutils.Console;

public class BaseballService {

    public static void gameStart() {

        InputView.getStartMessage();

        do {
            gamePlay();
        } while (gameEnd());

    }


    private static void gamePlay() {

        int[] computerBall = ComputerBallGenerator.generateComputerBall();


        int[] userInput = InputView.userInputNumber();



    }

    private static boolean gameEnd() {

        return false;
    }

}
