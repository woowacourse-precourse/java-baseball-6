package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;

public class RandomNumber extends Number {
    public RandomNumber() {
        ArrayList<Integer> randomValues = new ArrayList<>();
        while(randomValues.size() < size) {
            int randomDigit = Randoms.pickNumberInRange(1, 9);

            if(!randomValues.contains(randomDigit)) {
                randomValues.add(randomDigit);
            }
        }

        values = randomValues;
    }
}
