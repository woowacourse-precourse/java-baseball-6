package baseball.model;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class generateRandom {
    public List<Integer> randomNumber(){
        List<Integer> generateNumber = new ArrayList<>();

        while(generateNumber.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!generateNumber.contains(randomNumber)) {
                generateNumber.add(randomNumber);
            }
        }
        return generateNumber;
    }
}
