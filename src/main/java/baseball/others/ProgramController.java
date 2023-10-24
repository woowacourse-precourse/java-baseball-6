package baseball.others;

import static baseball.others.Constant.numberOfNumbers;
import static baseball.others.ExceptionHandling.restartException;

import java.util.List;
import java.util.Objects;

public class ProgramController {
    private static int strike;
    private static int ball;

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
            Output.printThreeStrike(strike);
            return true;
        } else if (ball == 0 && strike == 0) {
            Output.printNothing();
        } else if (ball != 0 && strike == 0) {
            Output.printOnlyBall(ball);
        } else if (ball == 0 && strike != 0) {
            Output.printOnlyStrike(strike);
        } else {
            Output.printBallAndStrike(ball, strike);
        }
        return false;
    }

    public static boolean ifRestart(final String restart) {
        if (Objects.equals(restart, "1")) {
            return true;
        } else if (Objects.equals(restart, "2")) {
            return false;
        } else {
            restartException();
        }
        return false;
    }
}