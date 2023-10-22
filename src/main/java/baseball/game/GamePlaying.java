package baseball.game;

import baseball.variable.ComputerNumber;
import baseball.variable.PlayerNumber;
import baseball.print.PrintMessage;

import java.util.List;
import java.util.ArrayList;
import java.util.Objects;

public class GamePlaying {
    private static final String STRIKE = "스트라이크";
    private static final String BALL = "볼";
    private static final String NOTHING = "낫싱";

    List<Integer> computerNumber = new ArrayList<>();
    List<Integer> playerNumber = new ArrayList<>();

    ComputerNumber cpu = new ComputerNumber();
    PlayerNumber player = new PlayerNumber();
    PrintMessage printer = new PrintMessage();

    public boolean playGame() {
        enterValue();

        int strike = 0;
        while (strike != 3) {
            strike = guessNumber();
        }

        return false;
    }

    private int guessNumber() {
        int strike = findStrike();
        int ball = findBall();
        printResult(strike, ball);


        return strike;
    }

    private void enterValue() {
        computerNumber = cpu.setComputerNumber(computerNumber);
        playerNumber = player.getPlayerNumber(playerNumber);
    }

    private int isSame(int i) {
        if (Objects.equals(computerNumber.get(i), playerNumber.get(i))) {
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

    private void printResult(int strike, int ball) {
        printBall(ball);
        printStrike(strike, ball);
        printNothing(strike, ball);
    }

    private void printStrike(int strike, int ball) {
        if (ball > 0 && strike > 0) {
            printBlank();
        }
        if (strike > 0) {
            System.out.print(strike + STRIKE);
        }
    }

    private void printBall (int ball) {
        if (ball > 0) {
            System.out.print(ball + BALL);
        }
    }

    private void printNothing (int strike, int ball) {
        if (strike == 0 && ball == 0) {
            System.out.println(NOTHING);
        }
    }

    private void printBlank() {
        System.out.print(" ");
    }

    private boolean isAnswer(int strike) {
        return strike != 3;
    }
}
