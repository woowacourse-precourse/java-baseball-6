package baseball.game;

import static camp.nextstep.edu.missionutils.Console.readLine;

import baseball.util.Print;
import baseball.util.Utility;
import baseball.util.Validation;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Game {
    private List<Integer> computer = null;
    private int strike = 0;
    private int ball = 0;

    public void play() {
        Print.showIntro();

        String restartOrExitNumber = "1";

        while (restartOrExitNumber.equals("1")) {
            initGame();
            playGame();
            restartOrExitNumber = gameOver();
        }

        Console.close();
    }

    private static String gameOver() {
        String restartOrExitNumber;
        Print.showGameOver();

        do {
            Print.showRestartOrExitInput();
            restartOrExitNumber = readLine();
        }
        while (!Validation.checkRestartOrExitNumber(restartOrExitNumber));
        return restartOrExitNumber;
    }

    private void initGame() {
        this.strike = 0;
        this.ball = 0;
        this.computer = Utility.assignComputerRandomNumber();
    }

    private void playGame() {
        while (this.strike != 3) {
            Print.showPredictUserInput();

            List<Integer> predictNumbers = Utility.input();
            checkPredictNumber(predictNumbers);

            Print.showPredictResult(this.strike, this.ball);
        }
    }

    private void checkPredictNumber(List<Integer> predictNumbers) {
        int ball = 0;
        int strike = 0;

        for (int i = 0; i < computer.size(); i++) {
            Integer computerNumber = computer.get(i);
            Integer predictNumber = predictNumbers.get(i);

            if (computerNumber.equals(predictNumber)) {
                strike++;
            } else {
                if (predictNumbers.contains(computerNumber)) {
                    ball++;
                }
            }
        }

        this.strike = strike;
        this.ball = ball;
    }

}
