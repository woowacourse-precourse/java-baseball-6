package baseball;

import java.util.List;

import static baseball.Application.computer;
import static baseball.Input.GUESS_INPUT_LENGTH;
import static baseball.Input.guess;

public class Judge {

    public static int ball;
    public static int strike;

    public static List<Integer> of() {
        initialize();
        count();
        return List.of(ball, strike);
    }

    private static void initialize() {
        ball = 0;
        strike = 0;
    }

    private static void count() {
        for (int i = 0; i < GUESS_INPUT_LENGTH; i++) {
            addIfBall(i);
            addIfStrike(i);
        }
    }

    private static void addIfBall(int i) {
        for (int j = 0; j < GUESS_INPUT_LENGTH; j++) {
            if (isBall(i, j)) {
                ball++;
            }
        }
    }

    private static void addIfStrike(int i) {
        if (isStrike(i)) {
            strike++;
        }
    }

    private static boolean isBall(int i, int j) {
        return i != j && computer.charAt(i) == guess.charAt(j);
    }

    private static boolean isStrike(int i) {
        return computer.charAt(i) == guess.charAt(i);
    }
}
