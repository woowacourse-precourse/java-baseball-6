package baseball;

import java.util.Arrays;

public class CompareNumber {
    public int getCount(int[] inputArr, int[] randomArr) {
        int ball = 0;
        for (int i = 0; i < inputArr.length; i++) {
            if (Arrays.binarySearch(randomArr, inputArr[i]) >= 0) {
                ball += 1;
            }
        }
        return ball;
    }

    public int getStrike(int[] inputArr, int[] randomArr) {
        int strike = 0;
        for (int i = 0; i < inputArr.length; i++) {
            if (Arrays.binarySearch(randomArr, inputArr[i]) >= 0) {
                if (inputArr[i] == randomArr[i]) {
                    strike += 1;
                }
            }
        }
        return strike;
    }
}
