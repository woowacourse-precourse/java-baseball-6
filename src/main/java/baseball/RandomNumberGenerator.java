package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RandomNumberGenerator {

    private final List<Integer> answerList;

    public RandomNumberGenerator() {
        this.answerList = new ArrayList<>();
    }

    public int getRandoms() {
        return Randoms.pickNumberInRange(1,9);
    }

    public List<Integer> setAnswerList() {
        while (answerList.size() < 3) {
            int randomNumber = getRandoms();
            if (!answerList.contains(randomNumber)) {
                answerList.add(randomNumber);
            }
        }
        return answerList;
    }
}
