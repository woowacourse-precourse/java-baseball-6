package baseball;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class NumberGenerator {

    public static int[] getRandomUniqueNumber() {
        int[] uniqueNumber = new int[3];
        for (int i = 0; i < 3; i++) {
            int digit = pickNumberInRange(1, 9);
            while (containsDigit(uniqueNumber, digit)) {
                digit = pickNumberInRange(1, 9);
            }
            uniqueNumber[i] = digit;
        }
        return uniqueNumber;
    }

    private static boolean containsDigit(int[] arr, int digit) {
        for (int num : arr) {
            if (num == digit) {
                return true;
            }
        }
        return false;
    }

}