package baseball.game;

import baseball.variable.ComputerNumber;
import baseball.variable.PlayerNumber;
import baseball.print.PrintResult;

import java.util.List;
import java.util.ArrayList;
import java.util.Objects;

public class GamePlaying {

    private int strike;
    private int ball;

    List<Integer> computerNumber = new ArrayList<>();
    List<Integer> playerNumber = new ArrayList<>();

    ComputerNumber cpu = new ComputerNumber();
    PlayerNumber player = new PlayerNumber();
    PrintResult printer = new PrintResult();

    public boolean playGame() {
        computerNumber.clear();
        computerNumber = cpu.setComputerNumber(computerNumber);;
        while (strike != 3) {
            resetValue();
            enterValue();
            guessNumber();
        }
        return false;
    }

    private void guessNumber() {
        findStrike();
        findBall(0);
        printer.printResult(strike, ball);
    }

    private void enterValue() {
        playerNumber.clear();
        playerNumber = player.getPlayerNumber(playerNumber);
    }

    private int isSameNumber(int i, int j) {
        if (computerNumber.get(i) == playerNumber.get(j)) {
            return 1;
        }
        return 0;
    }

    private void findStrike() {
        for (int i = 0; i < 3; i++) {
            strike += isSameNumber(i, i);
        }
    }

    private void findBall(int i) {
        if (i >= 3) {
            ball -= strike;
            return;
        }
        for (int j = 0; j < 3; j++) {
            ball += isSameNumber(i, j);
        }
        findBall(++i);
    }

    private void resetValue() {
        ball = 0;
        strike = 0;
    }
}
