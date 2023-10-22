package baseball.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

public final class HintProvider {
    public static final int ONLY_ONE = 1;

    public Map<HintType, Integer> compareNumbers(List<Integer> answerNumbers, List<Integer> playerNumbers) {
        Map<HintType, Integer> hintMap = new HashMap<>();

        for (int i = 0; i < playerNumbers.size(); i++) {
            HintType type = compareToAnswer(answerNumbers, playerNumbers.get(i), i);
            hintMap.merge(type, 0, increaseHintCount());
        }
        if (hintMap.containsKey(HintType.NOTHING)) {
            hintMap.put(HintType.NOTHING, ONLY_ONE);
        }
        return hintMap;
    }

    private HintType compareToAnswer(List<Integer> answerNumbers, int number, int index) {
        if (answerNumbers.contains(number) && answerNumbers.get(index) == number) {
            return HintType.STRIKE;
        }
        if (answerNumbers.contains(number)) {
            return HintType.BALL;
        }
        return HintType.NOTHING;
    }

    private BiFunction<Integer, Integer, Integer> increaseHintCount() {
        return (value, putValue) -> value + 1;
    }


}
