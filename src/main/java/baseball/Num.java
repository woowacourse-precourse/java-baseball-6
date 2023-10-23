package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;
import java.util.Set;

public class Num {

    public static final int DIGIT = 3; // 자릿수
    private int[] numsByDigit = new int[DIGIT];
    private int num;

    public Num(int num) {
        this.num = num;
        numsByDigit[0] = num / 100;
        numsByDigit[1] = (num % 100) / 10;
        numsByDigit[2] = num % 10;
        validate();
    }

    private void validate() {
        if (DIGIT != String.valueOf(num).length()) { // 자리수 체크
            throw new IllegalArgumentException();
        }

        if (numsByDigit[1] == 0 || numsByDigit[2] == 0) {
            throw new IllegalArgumentException();
        }

        if (duplicatedNumExist()) {
            throw new IllegalArgumentException();
        }
    }

    private boolean duplicatedNumExist() {
        Set<Integer> set = new HashSet<>();
        for (int n : numsByDigit) {
            set.add(n);
        }
        return set.size() != DIGIT;
    }

    public static Num random() {
        Set<Integer> uniqueDigits = generateUniqueDigits();
        int result = calculateNumber(uniqueDigits);
        return new Num(result);
    }

    private static Set<Integer> generateUniqueDigits() {
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

    public int getDigit(int i) {
        return numsByDigit[i];
    }

    public boolean contains(int num) {
        boolean result = false;
        for (int n : numsByDigit) {
            if (n == num) {
                result = true;
                break;
            }
        }
        return result;
    }
}