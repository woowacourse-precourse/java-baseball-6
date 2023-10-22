package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Computer {
    private final List<Integer> numbers;

    public Computer() {
        this.numbers = new ArrayList<>();
    }

    public void decideAnswer() {
        if (!numbers.isEmpty()) {
            numbers.clear();
        }

        while (numbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
    }

    public Map<String, Integer> count(List<Integer> inputNumbers) {
        Map<String, Integer> counts = new HashMap<>();
        int ballCount = 0;
        int strikeCount = 0;

        for (int i = 0; i < numbers.size(); i++) {
            if (Objects.equals(numbers.get(i), inputNumbers.get(i))) {
                strikeCount++;
                continue;
            }

            if (numbers.contains(inputNumbers.get(i))) {
                ballCount++;
            }
        }
        
        counts.put("strikeCount", strikeCount);
        counts.put("ballCount", ballCount);
        
        return counts;
    }
}
