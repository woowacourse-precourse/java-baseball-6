package baseball.domain.entity;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public final class Computer {
    private List<Integer> answer;

    public Computer() {
        this.answer = generateNumbersForBaseball();
    }

    public List<Integer> getAnswer() {
        return answer;
    }

    public void resetAnswer() {
        this.answer = generateNumbersForBaseball();
    }

    private List<Integer> generateNumbersForBaseball() {
        return Randoms.pickUniqueNumbersInRange(1, 9, 3);
    }

}
