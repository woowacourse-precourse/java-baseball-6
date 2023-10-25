package baseball.utils;

import baseball.model.Hint;
import baseball.model.Numbers;

public class HintGenerator {
    public static Hint generate(Numbers computer, Numbers player) {
        return Hint.from(countStrike(computer, player), countBall(computer, player));
    }

    private static Integer countStrike(Numbers computer, Numbers player) {
        Integer strike = 0;
        for (int index = 0; index < 3; index++) {
            if (computer.equalsAt(player.valueAt(index), index)) {
                strike++;
            }
        }
        return strike;
    }

    private static Integer countBall(Numbers computer, Numbers player) {
        Integer ball = 0;
        for (int index = 0; index < 3; index++) {
            if (computer.equalsAt(player.valueAt(index), index)) {
                continue;
            }
            if (computer.contains(player.valueAt(index))) {
                ball++;
            }
        }
        return ball;
    }
}
