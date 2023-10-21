package baseball.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class Referee {
    private final AnswerNumbers answerNumbers;
    private final Map<HintType, Integer> hintMap = new HashMap<>();

    public Referee(AnswerNumbers answerNumbers) {
        this.answerNumbers = answerNumbers;

        hintMap.put(HintType.STRIKE, 0);
        hintMap.put(HintType.BALL, 0);
        hintMap.put(HintType.NOTHING, 0);
    }

    public Map<HintType, Integer> getHint(PlayerNumbers playerNumbers) {
        List<Integer> numbers = playerNumbers.getNumbers();

        for (int i = 0; i < numbers.size(); i++) {
            HintType type = compareToAnswer(numbers.get(i), i);
            int count = hintMap.get(type);
            hintMap.put(type, count + 1);
        }
        return hintMap;
    }

    private HintType compareToAnswer(int number, int index) {
        List<Integer> answer = answerNumbers.getAnswerNumbers();

        if (answer.contains(number) && answer.get(index) == number) {
            return HintType.STRIKE;
        }
        if (answer.contains(number)) {
            return HintType.BALL;
        }
        return HintType.NOTHING;
    }


}
