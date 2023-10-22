package baseball.domain.Player;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Player {
    List<Integer> numbers;

    public Player() {

    }

    public Player(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public int getIndexNumbers(int i) {
        return numbers.get(i);
    }

    public void setNumbers(List<Integer> numbers) {
        this.numbers = numbers;
    }
}
