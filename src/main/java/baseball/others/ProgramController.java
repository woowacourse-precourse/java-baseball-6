package others;

import static others.Constant.numberOfNumbers;
import static others.ExceptionHandling.restartException;
import static others.Output.printBallAndStrike;
import static others.Output.printNothing;
import static others.Output.printOnlyBall;
import static others.Output.printOnlyStrike;
import static others.Output.printRestart;
import static others.Output.printThreeStrike;
import static others.Player.playerInputRestartNumber;

import java.util.List;
import java.util.Objects;

public class ProgramController {
    private static int strike;
    private static int ball;

    public static boolean ifRestart() {
        printRestart();
        String restartNumber = playerInputRestartNumber();
        return restartException(restartNumber);
    }

    public static void compareDigits(final List<Integer> computer, final List<Integer> player) {
        strike = 0;
        ball = 0;
        for (int i = 0; i < numberOfNumbers; i++) {
            if (Objects.equals(computer.get(i), player.get(i))) {
                strike++;
            } else {
                for (int j = 0; j < numberOfNumbers; j++) {
                    if (Objects.equals(computer.get(j), player.get(i))) {
                        ball++;
                    }
                }
            }
        }
    }

    public static boolean resultJudgment() {
        if (strike == 3) {
            printThreeStrike(strike);
            return true;
        } else if (ball == 0 && strike == 0) {
            printNothing();
        } else if (ball != 0 && strike == 0) {
            printOnlyBall(ball);
        } else if (ball == 0 && strike != 0) {
            printOnlyStrike(strike);
        } else {
            printBallAndStrike(ball, strike);
        }
        return false;
    }
}