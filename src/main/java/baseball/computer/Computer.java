package baseball.computer;

import baseball.utils.Count;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Computer {
    //---Constants---
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 9;
    public static final int ANSWER_DIGITS = 3;
    //-------------

    private final List<Integer> answer;

    public Computer() {
        this.answer = new ArrayList<>();
    }

    public void decideAnswer() {
        if (!answer.isEmpty()) {
            answer.clear();
        }

        while (answer.size() < ANSWER_DIGITS) {
            int randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber);
            }
        }
    }

    public Map<Count, Integer> count(List<Integer> inputNumbers) {
        Map<Count, Integer> counts = new HashMap<>();
        int ballCount = 0;
        int strikeCount = 0;

        for (int i = 0; i < ANSWER_DIGITS; i++) {
            if (Objects.equals(answer.get(i), inputNumbers.get(i))) {
                strikeCount++;
                continue;
            }

            if (answer.contains(inputNumbers.get(i))) {
                ballCount++;
            }
        }

        counts.put(Count.STRIKE, strikeCount);
        counts.put(Count.BALL, ballCount);

        return counts;
    }
}
