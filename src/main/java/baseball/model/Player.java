package baseball.model;

import static baseball.util.Constants.ANSWER_SIZE;
import static baseball.util.Constants.BALL;
import static baseball.util.Constants.NOTHING;
import static baseball.util.Constants.STRIKE;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Player {
    List<Integer> numberList;

    public Player(List<Integer> numberList) {
        validateSize(numberList);
        validateDuplication(numberList);
        this.numberList = numberList;
    }

    private void validateSize(List<Integer> numberList) {
        if (numberList.size() != ANSWER_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplication(List<Integer> numberList) {
        Set<Integer> numberSet = new HashSet<>(numberList);
        if (numberSet.size() != numberList.size()) {
            throw new IllegalArgumentException();
        }
    }

    public int determine(int element, int index) {
        if (numberList.contains(element)) {
            if (numberList.indexOf(element) == index) {
                return STRIKE;
            }
            if (numberList.indexOf(element) != index) {
                return BALL;
            }
        }
        return NOTHING;
    }
}
