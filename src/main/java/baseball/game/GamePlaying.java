package baseball.game;

import baseball.variable.ComputerNumber;
import baseball.variable.PlayerNumber;
import baseball.print.PrintResult;

import java.util.List;
import java.util.ArrayList;
import java.util.Objects;

public class GamePlaying {

    List<Integer> computerNumber = new ArrayList<>();
    List<Integer> playerNumber = new ArrayList<>();

    ComputerNumber cpu = new ComputerNumber();
    PlayerNumber player = new PlayerNumber();
    PrintResult printer = new PrintResult();

    public boolean playGame() {
        computerNumber.clear();
        computerNumber = cpu.setComputerNumber(computerNumber);

        int strike = 0;
        while (strike != 3) {
            enterValue();
            strike = guessNumber();
        }

        return false;
    }

    private int guessNumber() {
        int strike = findStrike();
        int ball = findBall();
        printer.printResult(strike, ball);

        return strike;
    }

    private void enterValue() {
        playerNumber.clear();
        playerNumber = player.getPlayerNumber(playerNumber);
    }

    private int isSame(int i) {
        if (computerNumber.get(i) == playerNumber.get(i)) {
            return 1;
        }
        return 0;
    }

    private int findStrike() {
        int strike = 0;
        for (int i = 0; i < 3; i++) {
            strike += isSame(i);
        }
        return strike;
    }

    private int findBall() {
        int ball = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i != j && computerNumber.get(i) == playerNumber.get(j)) {
                    ball += 1;
                }
            }
        }
        return ball;
    }
}
