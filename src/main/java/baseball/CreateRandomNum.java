package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class CreateRandomNum {
    private static final int MIN_RANDOM_NUMBER = 1;
    private static final int MAX_RANDOM_NUMBER = 9;
    public List<Integer> create() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            try {
                int randomNumber = Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);

                if (!computer.contains(randomNumber)) {
                    computer.add(randomNumber);
                }
            }
            catch (NoSuchElementException e) {
                throw e;
            }
        }
        return computer;
    }
}
