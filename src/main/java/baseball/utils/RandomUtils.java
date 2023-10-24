package baseball.utils;

import baseball.config.Config;
import camp.nextstep.edu.missionutils.Randoms;

public class RandomUtils {

    public static int[] getRandomNumbers(int size, int minValue, int maxValue) {
        int[] numbers = new int[size];

        for(int i=0; i<size;) {
            int randNum = Randoms.pickNumberInRange(minValue,maxValue);
            if(checkDuplicated(randNum,numbers)) {
                numbers[i++]=randNum;
            }
        }
        return numbers;
    }

    public static boolean checkDuplicated(int randNum, int[] numbers) {
        for(int j=0; j<numbers.length; j++) {
            if(numbers[j] == randNum) {
                return false;
            }
        }
        return true;
    }
}
