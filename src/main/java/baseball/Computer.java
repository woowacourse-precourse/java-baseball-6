package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;
    private static int[] digitBoard = null;

    public static void setRandomNumber() {
        int digit = 3;
        digitBoard = new int[MIN_NUMBER + MAX_NUMBER];

        while (digit >= 1) {
            int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
            if (digitBoard[randomNumber] == 0) {
                digitBoard[randomNumber] = digit--;
            }
        }
    }
}
