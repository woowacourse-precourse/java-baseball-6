package baseball.logic;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class CreateRandomNumbers {
    public List<Integer> answerNumbers;
    public CreateRandomNumbers() {
        this.answerNumbers = setRandomNumbers();
    }

    public List<Integer> setRandomNumbers(){
        List<Integer> randomNumbers = new ArrayList<>();

        while (randomNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randomNumbers.contains(randomNumber)) {
                randomNumbers.add(randomNumber);
            }
        }
        return randomNumbers;
    }
}
