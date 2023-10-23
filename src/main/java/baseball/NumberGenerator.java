package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class NumberGenerator {
    private final int MAX_NUMBER = 9;
    private final int MIN_NUMBER = 1;

    public List<Integer> generateRandomAnswer() {
        List<Integer> answer = new ArrayList<>();

        while (answer.size() < 3) {
            final int randomNumber = generateRandomNumber();

            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber);
            }
        }
        return answer;
    }

    public int generateRandomNumber() {
        final int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
        
        return randomNumber;
    }
}
