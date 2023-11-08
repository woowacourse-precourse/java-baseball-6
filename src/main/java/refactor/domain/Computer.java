package refactor.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;
    private static final int CNT_NUMBER = 3;

    private List<Integer> number;

    public Computer() {};

    public void randomNumberGenerator() {
        number = new ArrayList<>();

        while (number.size() < CNT_NUMBER) { insertRandomValue(); }

    }

    public List<Integer> getNumber() {
        return this.number;
    }

    private void insertRandomValue() {
        int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);

        if (!number.contains(randomNumber)) {
            number.add(randomNumber);
        }

    }

}
