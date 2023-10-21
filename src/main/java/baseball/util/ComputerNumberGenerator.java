package baseball.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class ComputerNumberGenerator {
    private List<Integer> computerNumbers = new ArrayList<>();

    public List<Integer> computerNumberGenerator() {
        computerNumbers.clear();
        while (computerNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumbers.contains(randomNumber)) {
                computerNumbers.add(randomNumber);
            }
        }
        return computerNumbers;
    }
}

