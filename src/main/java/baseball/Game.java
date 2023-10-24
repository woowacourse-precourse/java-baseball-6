package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;

public class Game {

    public Game() {
    }

    public String[] getComNumber() {
        String str = String.valueOf(Randoms.pickNumberInRange(100, 999));
        String[] strArray = str.split("");
        return strArray;
    }

    public int getStrikes(String[] inputArray, String[] targetArray) {
        int strikes = 0;

        for (int i = 0; i < targetArray.length; i++) {
            if (inputArray[i].equals(targetArray[i])) {
                strikes++;
            }
        }

        return strikes;
    }

    public int getBalls(String[] inputArray, String[] targetArray) {
        int balls = 0;

        for (String i : inputArray) {
            if (Arrays.asList(targetArray).contains(i)) {
                balls++;
            }
        }

        return balls - getStrikes(inputArray, targetArray);
    }
}
