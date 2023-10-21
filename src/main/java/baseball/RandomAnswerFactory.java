package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class RandomAnswerFactory {
    public Answer getRandomAnswer(){
        List<Integer> randomAnswer = new ArrayList<>();
        while (randomAnswer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randomAnswer.contains(randomNumber)) {
                randomAnswer.add(randomNumber);
            }
        }
        return new Answer(randomAnswer.get(0), randomAnswer.get(1), randomAnswer.get(2));
    }
}
