package baseball.domain;

import java.util.List;

public class Player {
    private List<Integer> pickNumbers;

    public Player(List<Integer> pickNumbers) {
        this.pickNumbers = pickNumbers;
    }
    public List<Integer> getPickNumbers() {
        return pickNumbers;
    }
}
