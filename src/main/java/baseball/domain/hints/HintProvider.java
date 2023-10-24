package baseball.domain.hints;

import baseball.domain.numbers.AnswerNumber;
import baseball.domain.numbers.BaseBallNumber;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public final class HintProvider {
    public static final int ONLY_ONE = 1;

    private final AnswerNumber answerNumber;

    public HintProvider(AnswerNumber answerNumber) {
        this.answerNumber = answerNumber;
    }

    public Map<HintType, Integer> compareNumbers(BaseBallNumber playerNumber) {
        Map<HintType, Integer> hintMap = new HashMap<>();

        for (int i = 0; i < BaseBallNumber.NUMBER_LENGTH; i++) {
            HintType type = compareToAnswer(playerNumber, i);
            hintMap.merge(type, 1, increaseHintCount());
        }
        trimHint(hintMap);
        return hintMap;
    }

    private HintType compareToAnswer(BaseBallNumber number, int index) {
        boolean isMatch = answerNumber.isSameNumberOfIndex(number, index);
        boolean hasContain = answerNumber.hasContainNumberOfIndex(number, index);

        if (isMatch) {
            return HintType.STRIKE;
        }
        if (hasContain) {
            return HintType.BALL;
        }
        return HintType.NOTHING;
    }

    private BiFunction<Integer, Integer, Integer> increaseHintCount() {
        return (value, unused) -> value + 1;
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