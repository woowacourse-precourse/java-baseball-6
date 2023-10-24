package baseball.game;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class NumberGengerator {
    public List<Integer> numberGenerate(){
        List<Integer> generateNumber = new ArrayList<>();
        while (generateNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            putNotDuplicatedNumber(generateNumber, randomNumber);
        }
        return generateNumber;
    }

    private void putNotDuplicatedNumber(List<Integer> generateNumber, int randomNumber) {
        if (!generateNumber.contains(randomNumber)) {
            generateNumber.add(randomNumber);
        }
    }
}
