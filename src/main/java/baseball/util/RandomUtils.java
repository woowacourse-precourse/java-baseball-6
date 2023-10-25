package baseball.util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomUtils {
    public static int[] setRandomNumber(int size, int start, int end){
        ArrayList<Integer> numArray = new ArrayList<>();

        while(numArray.size() < size){
            int num = Randoms.pickNumberInRange(start, end);
            if(!numArray.contains(num)){
                numArray.add(num);
            }
        }
        int[] nums = numArray.stream().mapToInt(i -> i).toArray();
        return nums;
    }

}
