package baseball.domain.entity;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public final class Answer {
    private List<Integer> numberList;

    public Answer() {
        this.numberList = generateNumbersForBaseball();
    }

    public List<Integer> getNumberList() {
        return numberList;
    }

    public void resetAnswer() {
        this.numberList = generateNumbersForBaseball();
    }

    private List<Integer> generateNumbersForBaseball() {
        return Randoms.pickUniqueNumbersInRange(1, 9, 3);
    }

}
