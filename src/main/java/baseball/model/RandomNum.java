package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomNum {

    private static final int RandomNum_Start = 1;
    private static final int RandomNum_End = 9;
    private static final int RandomNum_Length = 3;

    public List<Integer> GenerateRandomNum() {
        List<Integer> RandomNum = new ArrayList<>();
        while (RandomNum.size() < RandomNum_Length) {
            int randomNumber = Randoms.pickNumberInRange(RandomNum_Start, RandomNum_End);
            if (!RandomNum.contains(randomNumber)) {
                RandomNum.add(randomNumber);
            }
        }
        System.out.println("aaaaaaaaaaaaaaaaaaa"+RandomNum);
        return RandomNum;
    }
}
