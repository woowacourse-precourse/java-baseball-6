package baseball.model;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import java.util.ArrayList;
import java.util.List;

public class ComputerNumber {
    public static List<Integer> makeComputerNumber() {
        List<Integer> answerNumber = new ArrayList<>();

        while (answerNumber.size() < 3) {
            int randomNumber = pickNumberInRange(1, 9);
            if (!answerNumber.contains(randomNumber)) {
                answerNumber.add(randomNumber);
            }
        }

        return answerNumber;
    }
}
