package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static baseball.util.NumberConst.*;

public class RandomBallNumberGenerator {
    private int getRandomNumber1to9() {
        return Randoms.pickNumberInRange(START_INCLUSIVE, END_INCLUSIVE);
    }

    public List<Integer> generateAnswerNumbers() {
        Set<Integer> answer = new HashSet<>();
        while (answer.size() < NUMBER_SIZE) {
            answer.add(getRandomNumber1to9());
        }
        return new ArrayList<>(answer);
    }
}
