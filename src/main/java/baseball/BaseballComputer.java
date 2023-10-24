package baseball;

import java.util.Arrays;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

public class BaseballComputer {
    private int[] numArray;

    public BaseballComputer() {
        this.numArray = new int[10];
    }
    public void selectNumber() {
        Arrays.fill(numArray, 0);
        for (int i = 1; i <= 3; ++i) {
            int randomNumber;
            do {
                randomNumber = Randoms.pickNumberInRange(1, 9);
            } while (numArray[randomNumber] != 0);
            numArray[randomNumber] = i;
        }
    }

    public boolean chkInputError(String input) {
        int[] duplicatedCheck = new int[10];

        if (input.length() != 3) {
            return true;
        }
        for (char c : input.toCharArray()) {
            if (c < '1' || c > '9') {
                return true;
            }
            int intDigit = Character.getNumericValue(c);
            if (duplicatedCheck[intDigit] != 0) {
                return true;
            }
            duplicatedCheck[intDigit] = 1;
        }
        return false;
    }
}
