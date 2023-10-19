package baseball;


import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Number {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;
    private static final int CNT_NUMBER = 3;

    private List<Integer> number;

    public Number() {}

    public List<Integer> getNumber() {
        return this.number;
    }

    public void randomNumberGenerator() {
        List<Integer> number = new ArrayList<>();

        while (number.size() < CNT_NUMBER) {
            int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
            if (!number.contains(randomNumber)) {
                number.add(randomNumber);
            }
        }

        this.number = number;
    }


}
