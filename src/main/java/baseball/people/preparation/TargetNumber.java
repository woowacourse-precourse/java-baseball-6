package baseball.people.preparation;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;

class TargetNumber {
    private int[] number = new int[3];

    private TargetNumber() {
        number = this.getRandomNumber();
    }

    private TargetNumber(int a, int b, int c) {
        this.number[0] = a;
        this.number[1] = b;
        this.number[2] = c;
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
        return number[idx] == num;
    }

    boolean isBall(int num) {
        if (!isValidNumber(num)) {
            return false;
        }
        return Arrays.stream(number).anyMatch(i -> i == num);
    }

    int[] getRandomNumber() {
        boolean[] duplicationCheck = new boolean[10];
        int[] answer = new int[3];
        for (int i = 0; i < 3; i++) {
            int value = Randoms.pickNumberInRange(1, 9);
            while (duplicationCheck[value]) {
                value = Randoms.pickNumberInRange(1, 9);
            }
            duplicationCheck[value] = true;
            answer[i] = value;
        }
        return answer;
    }

    private static boolean isValidNumber(int i) {
        return i >= 1 && i <= 9;
    }

    private static boolean isValidIndex(int i) {
        return i >= 0 && i <= 2;
    }
}
