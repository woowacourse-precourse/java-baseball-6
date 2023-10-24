package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;
import java.util.Set;

public class Num {

    public static final int DIGIT = 3; // 자릿수
    private final int[] digitList = new int[DIGIT];
    private final int value;

    public Num(int value) {
        this.value = value;
        digitList[0] = value / 100;
        digitList[1] = (value % 100) / 10;
        digitList[2] = value % 10;
        checkValidity();
    }

    private void checkValidity() {
        if (DIGIT != String.valueOf(value).length()) { // 자리수 체크
            throw new IllegalArgumentException();
        }

        if (digitList[1] == 0 || digitList[2] == 0) {
            throw new IllegalArgumentException();
        }

        if (hasDuplicateDigits()) {
            throw new IllegalArgumentException();
        }
    }

    private boolean hasDuplicateDigits() {
        Set<Integer> set = new HashSet<>();
        for (int n : digitList) {
            set.add(n);
        }
        return set.size() != DIGIT;
    }

    public static Num random() {
        Set<Integer> uniqueDigits = createUniqueDigits();
        int result = calculateNumber(uniqueDigits);
        return new Num(result);
    }

    private static Set<Integer> createUniqueDigits() {
        Set<Integer> uniqueDigits = new HashSet<>();
        while (uniqueDigits.size() < DIGIT) {
            int randomNum = Randoms.pickNumberInRange(1, 9);
            uniqueDigits.add(randomNum);
        }
        return uniqueDigits;
    }

    private static int calculateNumber(Set<Integer> uniqueDigits) {
        int result = 0;
        for (int digit : uniqueDigits) {
            result = result * 10 + digit;
        }
        return result;
    }

    public int getDigitAt(int i) {
        return digitList[i];
    }

    public boolean contains(int num) {
        boolean result = false;
        for (int n : digitList) {
            if (n == num) {
                result = true;
                break;
            }
        }
        return result;
    }
}