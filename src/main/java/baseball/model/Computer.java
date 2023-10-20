package baseball.model;

import baseball.common.GameStatus;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Computer {
    private List<Integer> gameNumbers;
    private GameStatus gameStatus;

    public Computer() {
        this.gameStatus = GameStatus.ONPLAYING;
    }

    public void createRandomNumbers() {
        Set<Integer> numbers = new HashSet<>();

        while (numbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            numbers.add(randomNumber);
        }

        this.gameNumbers = new ArrayList<>(numbers);
    }
}
