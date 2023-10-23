package baseball.service;

import baseball.util.ComputerBallGenerator;
import baseball.util.InputCalculator;
import baseball.util.OutputCalculator;
import baseball.view.InputView;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class BaseballService {

    public static void gameStart() {

        InputView.getStartMessage();


            gamePlay();


    }


    private static void gamePlay() {

        int[] computerBall = ComputerBallGenerator.generateComputerBall();

        do {
            List<Integer> userInput = InputView.userInputNumber();


        }while(gameEnd());



    }

    private static boolean gameEnd() {

        return false;
    }

}
