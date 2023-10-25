package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    private final int RANDOM_MAX_NUM = 9;
    private final int RANDOM_MIN_NUM = 1;
    private List<Integer> computerNumber = new ArrayList<>();

    public List<Integer> createRandomNumber(){

        while (computerNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(RANDOM_MIN_NUM, RANDOM_MAX_NUM);
            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber);
            }
        }

        return computerNumber;
    }
}
