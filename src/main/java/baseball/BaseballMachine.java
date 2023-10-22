package baseball;

import java.util.HashSet;
import java.util.Set;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class BaseballMachine {
    private final Set<Integer> numberSet;

    public BaseballMachine() {
        this.numberSet = new HashSet<>();
    }

    public void insertNumbers() {
        numberSet.clear();
        while(numberSet.size() < 3) {
            numberSet.add(pickNumberInRange(1, 9));
        }
    }

    // Test
    public void showNumbers() {
        numberSet.forEach(System.out::println);
    }



}
