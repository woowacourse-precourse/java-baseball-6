package baseball.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class Referee {
    private final AnswerNumbers answerNumbers;

    public Referee(AnswerNumbers answerNumbers) {
        this.answerNumbers = answerNumbers;

        initHintMap();
    }

    private Map<HintType, Integer> initHintMap() {
        Map<HintType, Integer> map = new HashMap<>();
        map.put(HintType.STRIKE, 0);
        map.put(HintType.BALL, 0);
        map.put(HintType.NOTHING, 0);
        return map;
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

    public boolean isSameWithAnswer(PlayerNumbers playerNumbers) {
        String numbers = playerNumbers.getNumbers().toString();
        String answer = answerNumbers.getAnswerNumbers().toString();

        return numbers.equals(answer);
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
