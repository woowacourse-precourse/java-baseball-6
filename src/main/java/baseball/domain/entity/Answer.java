package baseball.domain.entity;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public final class Answer {
    private List<Integer> numbers;

    public Answer() {
        this.numbers = generateNumbersForBaseball();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void resetAnswer() {
        this.numbers = generateNumbersForBaseball();
    }

    private List<Integer> generateNumbersForBaseball() {
        return Randoms.pickUniqueNumbersInRange(1, 9, 3);
    }

}
