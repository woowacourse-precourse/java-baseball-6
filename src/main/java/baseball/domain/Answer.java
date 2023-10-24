package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

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
        return (int) IntStream.range(0, numbers.size())
                .filter(i -> inputNums[i] == numbers.get(i))
                .count();
    }
}
