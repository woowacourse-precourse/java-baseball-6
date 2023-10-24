package baseball.utils;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomUtil {

    public static List<Integer> generateRandomNumber(int size) {
        List<Integer> randomNumberList = new ArrayList<>();
        while(randomNumberList.size() < size) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if(!randomNumberList.contains(randomNumber)) {
                randomNumberList.add(randomNumber);
            }
        }
        return randomNumberList;
    }
}
