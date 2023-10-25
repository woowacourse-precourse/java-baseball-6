package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.Set;

public class RandomNumber {
    public int randomNum() {
        return Randoms.pickNumberInRange(1,9);
    }

    public int[] createRanArr(){
//        int[] ranArr = new int[3];
        Set<Integer> numSet = new HashSet<>();
        while(numSet.size()<3){
            int ranNum = randomNum();
            numSet.add(ranNum);
        }
        int[] ranArr = numSet.stream().mapToInt(Integer::intValue).toArray();
        return ranArr;
    }
}
