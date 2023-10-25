package baseball.domain.service;

import baseball.domain.entity.Hint;

import java.util.List;
import java.util.Set;

public class HintService {
    public Hint createHintFromAnswerNumbersAndInputNumbers(final List<Integer> answerNumberList, final List<Integer> inputNumberList) {
        final int strikeCount = getStrikeCount(answerNumberList, inputNumberList);
        final int containedNumbersCount = getContainedInputNumbers(answerNumberList, inputNumberList).size();

        return new Hint(strikeCount, containedNumbersCount - strikeCount);
    }

    private int getStrikeCount(final List<Integer> answer, final List<Integer> inputNumberList) {
        return (int) getContainedInputNumbers(answer, inputNumberList).stream()
                .filter(idx -> answer.get(idx).equals(inputNumberList.get(idx)))
                .count();
    }

    private List<Integer> getContainedInputNumbers(final List<Integer> answer, final List<Integer> inputNumberList) {
        final Set<Integer> answerSet = Set.copyOf(answer);

        return inputNumberList.stream()
                .filter(answerSet::contains)
                .toList();
    }
}
