package baseball;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

class RandomNumberGenerator {
    final int digit = 3;

    public RandomNumberGenerator() {
    }

    public List<Integer> setRandomNum() {
        List<Integer> randomNum = new ArrayList<>();

        while(randomNum.size() < digit) {
            int rnum = Randoms.pickNumberInRange(1, 9);
            if (!randomNum.contains(rnum)) {
                randomNum.add(rnum);
            }
        }
        return randomNum;
    }
}