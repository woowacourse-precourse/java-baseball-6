package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static baseball.constants.GameOption.ANSWER_NUMBER_LENGTH;

public class Answer {
    private List<Integer> numbers = new ArrayList<>();

    public void pickNumbers() {
        this.numbers.clear();

        while (numbers.size() < ANSWER_NUMBER_LENGTH.getLength()) {
            int number = Randoms.pickNumberInRange(1, 9);
            if (!numbers.contains(number)) {
                numbers.add(number);
            }
        }
    }

    public int[] calculateScore(int[] inputNums) {
        int countOfCommons = calculateCommons(inputNums);
        int countOfStrikes = calculateStrikes(inputNums);
        int countOfBalls = countOfCommons - countOfStrikes;

        return new int[]{countOfStrikes, countOfBalls};
    }

    private int calculateCommons(int[] inputNums) {
        return (int) Arrays.stream(inputNums)
                .filter(number -> this.numbers.contains(number))
                .count();
    }

    private int calculateStrikes(int[] inputNums) {
        int result = 0;
        for (int i = 0; i < this.numbers.size(); i++) {
            if (inputNums[i] == this.numbers.get(i)) {
                result++;
            }
        }
        return result;
    }
}
