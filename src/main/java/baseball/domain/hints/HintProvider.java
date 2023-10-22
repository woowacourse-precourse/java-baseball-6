package baseball.domain.hints;

import baseball.domain.numbers.AnswerNumbers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

public final class HintProvider {
    public static final int ONLY_ONE = 1;
    private final AnswerNumbers answerNumbers;

    public HintProvider(AnswerNumbers answerNumbers) {
        this.answerNumbers = answerNumbers;
    }

    public Map<HintType, Integer> compareNumbers(List<Integer> playerNumber) {
        Map<HintType, Integer> hintMap = new HashMap<>();

        for (int i = 0; i < playerNumber.size(); i++) {
            HintType type = compareToAnswer(playerNumber.get(i), i);
            hintMap.merge(type, 1, increaseHintCount());
        }
        trimHint(hintMap);
        return hintMap;
    }

    private HintType compareToAnswer(int number, int index) {

        Integer answerIndex = answerNumbers.findIndexOfSameNumber(number);

        if (answerIndex == null) {
            return HintType.NOTHING;
        }
        if (answerIndex == index) {
            return HintType.STRIKE;
        }
        return HintType.BALL;
    }

    private BiFunction<Integer, Integer, Integer> increaseHintCount() {
        return (value, putValue) -> value + 1;
    }

    private void trimHint(Map<HintType, Integer> hintMap) {
        if (hintMap.containsKey(HintType.NOTHING)) {
            hintMap.put(HintType.NOTHING, ONLY_ONE);
        }
        if (hintMap.keySet().size() > 1) {
            hintMap.remove(HintType.NOTHING);
        }
    }
}
