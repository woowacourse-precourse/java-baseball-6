package baseball;

import java.util.List;

public class BaseballGame {

    static int strike = 0;
    static int ball = 0;

    public static void game(List<Integer> answer, List<Integer> input) {

        for (int i = 0; i < input.size(); i++) {

            for (int j = 0; j < answer.size(); j++) {

                if (input.get(i) == answer.get(j)) {
                    if (i == j) strike++;
                    else ball ++;
                }
            }
        }
    }

    public static void reset() {
        strike = 0;
        ball = 0;
    }

    public static int getStrike() {
        return strike;
    }

    public static int getBall() {
        return ball;
    }
}
