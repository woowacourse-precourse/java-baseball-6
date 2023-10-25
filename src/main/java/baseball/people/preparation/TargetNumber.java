package baseball.people.preparation;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class TargetNumber {
    private final List<Integer> number = new ArrayList<>();

    private TargetNumber() {
        this.getRandomNumber();
    }

    private TargetNumber(int a, int b, int c) {
        number.add(a);
        number.add(b);
        number.add(c);
    }

    static TargetNumber generate(int a, int b, int c) {
        if (isValidNumber(a) && isValidNumber(b) && isValidNumber(c)) {
            return new TargetNumber(a, b, c);
        }

        return new TargetNumber();
    }

    boolean isStrike(int num, int idx) {
        if (!isValidNumber(num) || !isValidIndex(idx)) {
            return false;
        }

        return number.get(idx) == num;
    }

    boolean isBall(int num) {
        if (!isValidNumber(num)) {
            return false;
        }

        return number.contains(num);
    }

    void getRandomNumber() {
        boolean[] duplicationCheck = new boolean[10];
        for (int i = 0; i < 3; i++) {
            int value = Randoms.pickNumberInRange(1, 9);

            while (duplicationCheck[value]) {
                value = Randoms.pickNumberInRange(1, 9);
            }

            duplicationCheck[value] = true;
            number.add(value);
        }
    }

    private static boolean isValidNumber(int i) {
        return i >= 1 && i <= 9;
    }

    private static boolean isValidIndex(int i) {
        return i >= 0 && i <= 2;
    }
}
