package baseball.entity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class GameLogic {
    private Map<String, Integer> compareResult = new HashMap<>();

    public Map compareNumbers(List<Integer> playerNumbers, List<Integer> computerNumbers) {
        compareResult.put("strike", 0);
        compareResult.put("balls", 0);

        for (int i = 0; i < playerNumbers.size(); i++) {
            for (int j = 0; j < computerNumbers.size(); j++) {
                if (Objects.equals(playerNumbers.get(i), computerNumbers.get(j)) && i == j) {
                    compareResult.put("strike", compareResult.get("strike") + 1);
                } else if (Objects.equals(playerNumbers.get(i), computerNumbers.get(j)) && i != j) {
                    compareResult.put("balls", compareResult.get("balls") + 1);
                }
            }
        }

        return compareResult;
    }
}
