package baseball.version1;

import static baseball.version1.Constants.DIGIT_NUMBER;
import static baseball.version1.Constants.RANGE_END_NUMBER;
import static baseball.version1.Constants.RANGE_START_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;

public class Computer {

    public ArrayList<Integer> getComputerAnswer() {
        ArrayList<Integer> computerAnswer = new ArrayList<>();
        while (computerAnswer.size() < DIGIT_NUMBER) {
            int randomNumber = Randoms.pickNumberInRange(RANGE_START_NUMBER, RANGE_END_NUMBER);
            if (!computerAnswer.contains(randomNumber)) {
                computerAnswer.add(randomNumber);
            }
        }
        return computerAnswer;
    }
}
