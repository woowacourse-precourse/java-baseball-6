package baseball.utils;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;
import java.util.Set;

public class RandomUtils {

    public static int[] getRandomNumbers(int size, int minValue, int maxValue) {
        int[] numbers = new int[size];
        Set<Integer> uniqueNumber = new HashSet<>();

        for(int i=0; i<size;) {
            int randNum = Randoms.pickNumberInRange(minValue,maxValue);
            if(uniqueNumber.add(randNum)){
                numbers[i++]=randNum;
            }
        }
        return numbers;
    }
}
