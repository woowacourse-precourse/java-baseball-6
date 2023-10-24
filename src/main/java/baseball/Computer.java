package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import static baseball.constants.Constant.*;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private List<Integer> computerNumber;

    public void setComputerNumber() {
        computerNumber = new ArrayList<>();
        while (computerNumber.size() < NUMBER_SIZE) {
            int randomNumber = Randoms.pickNumberInRange(RANDOM_MIN, RANDOM_MAX);
            if (!computerNumber.contains(randomNumber)) {
                computerNumber.add(randomNumber);
            }
        }
        System.out.println(computerNumber);
    }

    public Score getScore(List<Integer> input) {
        Score score = new Score();
        for (int i = 0; i < NUMBER_SIZE; i++) {
            int num = input.get(i);
            if (computerNumber.get(i).equals(num)) score.addStrike();
            else if (computerNumber.contains(num)) score.addBall();
        }
        return score;
    }
}
