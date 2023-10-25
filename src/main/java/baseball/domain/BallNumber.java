package baseball.domain;

import baseball.util.ListUtility;
import java.util.List;

public class BallNumber {
    public static int LENGTH = 3;

    private final List<Integer> splitNumber;

    BallNumber(int number) {
        this.splitNumber = ListUtility.splitDigitsIntoList(number);
    }

    public int getNumberAt(int index) {
        return splitNumber.get(index);
    }

    public boolean contains(int number) {
        return splitNumber.contains(number);
    }
}
