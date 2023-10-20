package baseball.model;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public record Number(int value) {
    public static int START_NUMBER = 1;
    public static int END_NUMBER = 9;
    public Number {
        if (value < START_NUMBER || END_NUMBER < value) {
            throw new IllegalArgumentException();
        }
    }

    public static Number createRandomNumber() {
        return new Number(pickNumberInRange(Number.START_NUMBER, Number.END_NUMBER));
    }
}
