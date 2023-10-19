package baseball;


import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Number {

    private List<Integer> number;

    public Number() {}

    public List<Integer> getNumber() {
        return this.number;
    }

    public void randomNumberGenerator() {
        List<Integer> number = new ArrayList<>();

        while (number.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!number.contains(randomNumber)) {
                number.add(randomNumber);
            }
        }

        this.number = number;
    }


}
