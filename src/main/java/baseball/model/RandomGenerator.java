package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RandomGenerator {
    public String createNumbers() {
        StringBuilder selectedNumbers = new StringBuilder();
        List<Integer> selectedList = new ArrayList<>();
        while (selectedList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!selectedList.contains(randomNumber)) {
                selectedList.add(randomNumber);
                selectedNumbers.append(randomNumber);
            }
        }
        return selectedNumbers.toString();
    }
}
