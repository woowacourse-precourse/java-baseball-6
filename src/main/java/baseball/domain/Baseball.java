package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.SimpleTimeZone;

public class Baseball {
    List<Integer> randomNumbers = new ArrayList<>();

    public List<Integer> generateRandomNumber() {
        while (randomNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randomNumbers.contains(randomNumber)) {
                randomNumbers.add(randomNumber);
            }
        }
        return randomNumbers;
    }

    public Map<String, Integer> findStrike(List<Integer> randomNumbers, List<Integer> userInput) {
        int strikeCount = 0;
        for (int i = 0; i < userInput.size(); i++) {
            if (Objects.equals(randomNumbers.get(i), userInput.get(i))) {
                strikeCount++;
            }
        }

        Map<String, Integer> result = new HashMap<>();
        result.put("strike", strikeCount);
        return result;
    }
}
