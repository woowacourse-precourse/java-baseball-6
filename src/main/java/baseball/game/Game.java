package baseball.game;

import static camp.nextstep.edu.missionutils.Console.readLine;

import baseball.constant.GameConstant;
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

        String restartOrExitNumber = GameConstant.RESTART_GAME.number;

        while (restartOrExitNumber.equals(GameConstant.RESTART_GAME.number)) {
            initGame();
            playGame();
            restartOrExitNumber = gameOver();
        }

        Console.close();
    }

    private static String gameOver() {
        Print.showGameOver();

        String restartOrExitNumber;

        do {
            Print.showRestartOrExitInput();
            restartOrExitNumber = readLine().trim();
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
            comparePredictNumberAndComputerNumber(predictNumbers);

            Print.showPredictResult(this.strike, this.ball);
        }
    }

    private void comparePredictNumberAndComputerNumber(List<Integer> predictNumbers) {
        int ball = 0;
        int strike = 0;

        for (int i = 0; i < computer.size(); i++) {
            Integer computerNumber = computer.get(i);
            Integer predictNumber = predictNumbers.get(i);

            if (isStrike(computerNumber, predictNumber)) {
                strike++;
                continue;
            }

            if (isBall(predictNumbers, computerNumber, i)) {
                ball++;
            }
        }

        this.strike = strike;
        this.ball = ball;
    }

    private static boolean isBall(List<Integer> predictNumbers, Integer computerNumber, int index) {
        return predictNumbers.contains(computerNumber) && !predictNumbers.get(index).equals(computerNumber);
    }

    private static boolean isStrike(Integer computerNumber, Integer predictNumber) {
        return computerNumber.equals(predictNumber);
    }

}
