package baseball;

import java.util.List;

import static baseball.Application.computer;
import static baseball.Input.GUESS_INPUT_LENGTH;
import static baseball.Input.guess;

public class Judge {

    private static int ball;
    private static int strike;

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
            for (int j = 0; j < GUESS_INPUT_LENGTH; j++) {
                countStrike(i, j);
                countBall(i, j);
            }
        }
    }

    private static void countBall(int i, int j) {
        if (i != j && computer.charAt(i) == guess.charAt(j)) {
            ball++;
        }
    }

    private static void countStrike(int i, int j) {
        if (i == j && computer.charAt(i) == guess.charAt(j)) {
            strike++;
        }
    }
}
