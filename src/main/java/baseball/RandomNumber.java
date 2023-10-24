package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RandomNumber {

    private final List<Integer> randomNumber;

    public RandomNumber() {
        this.randomNumber = new ArrayList<>();
        while (randomNumber.size() < 3) {
            int randomNumberInt = Randoms.pickNumberInRange(1, 9);
            if (!randomNumber.contains(randomNumberInt)) {
                randomNumber.add(randomNumberInt);
            }
        }
    }

    public boolean isNumberContain(int number) {
        return randomNumber.contains(number);
    }

    public int findIndex(int number) {
        return randomNumber.indexOf(number);
    }

}
