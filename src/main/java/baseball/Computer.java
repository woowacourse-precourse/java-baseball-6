package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Computer {
    private final List<Integer> answer;

    public Computer() {
        this.answer = new ArrayList<>();
    }

    public void decideAnswer() {
        if (!answer.isEmpty()) {
            answer.clear();
        }

        while (answer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber);
            }
        }
    }

    public Map<String, Integer> count(List<Integer> inputNumbers) {
        Map<String, Integer> counts = new HashMap<>();
        int ballCount = 0;
        int strikeCount = 0;

        for (int i = 0; i < answer.size(); i++) {
            if (Objects.equals(answer.get(i), inputNumbers.get(i))) {
                strikeCount++;
                continue;
            }

            if (answer.contains(inputNumbers.get(i))) {
                ballCount++;
            }
        }
        
        counts.put("strikeCount", strikeCount);
        counts.put("ballCount", ballCount);
        
        return counts;
    }
}
