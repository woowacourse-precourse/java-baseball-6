package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static baseball.constants.GameOption.ANSWER_NUMBER_LENGTH;

public class Answer {
    private List<Integer> numbers = new ArrayList<>();

    public Answer() {
        pickNumbers();
        this.numbers = Collections.unmodifiableList(numbers);
    }

    private void pickNumbers() {
        while (numbers.size() < ANSWER_NUMBER_LENGTH.getLength()) {
            int number = Randoms.pickNumberInRange(1, 9);
            if (!numbers.contains(number)) {
                numbers.add(number);
            }
        }
    }

    public static Answer createAnswer() {
        return new Answer();
    }
}
