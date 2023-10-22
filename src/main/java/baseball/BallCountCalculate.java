package baseball;

import java.util.Arrays;

public class BallCountCalculate {


    public static int getStrike(String randomNum, String inputNum) {
        int strikeCount = 0;
        for (int i = 0; i < inputNum.length(); i++) {
            if (randomNum.charAt(i) == inputNum.charAt(i)) {
                strikeCount++;
            }
        }
        return strikeCount;
    }
}
