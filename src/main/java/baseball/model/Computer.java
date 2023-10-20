package baseball.model;

import baseball.common.GameStatus;
import baseball.view.Output;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Computer {
    private List<Integer> gameNumbers;
    private GameStatus status;

    public Computer() {
        this.status = GameStatus.ONPLAYING;
    }

    public void createRandomNumbers() {
        Set<Integer> numbers = new HashSet<>();

        while (numbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            numbers.add(randomNumber);
        }

        this.gameNumbers = new ArrayList<>(numbers);
    }

    public boolean isEnd() {
        return this.status.isEnd();
    }

    public boolean isAllCorrect() {
        return this.status.isAllCorrect();
    }
}
