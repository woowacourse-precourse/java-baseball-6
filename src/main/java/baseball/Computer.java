package baseball;

import static baseball.Constants.*;

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
