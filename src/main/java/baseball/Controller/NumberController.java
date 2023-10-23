package baseball.Controller;

import java.util.HashSet;
import java.util.Set;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class NumberController {
    static final int NUMOFDIGIT = 3;

    public static Integer[] createRandomNumber(){

        Set<Integer> uniqueNumbers = new HashSet<>();

        while (uniqueNumbers.size() < NUMOFDIGIT) {
            int randomNumbers = pickNumberInRange(1,9);
            uniqueNumbers.add(randomNumbers);
        }

        // Set return
        return uniqueNumbers.toArray(new Integer[0]);

    }
}
