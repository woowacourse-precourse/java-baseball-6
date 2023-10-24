package baseball.model;

import baseball.util.GameConfig;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Result {
    private List<Integer> numbers;

    public Result() {
        this.numbers = new ArrayList<>();
    }

    public Result(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public Result makeResult(int size) {
        Set<Integer> set = new HashSet<>();

        while (set.size() < size) {
            int tmpNum = Randoms.pickNumberInRange(
                    GameConfig.RANDOM_MIN_VALUE.getValue(),
                    GameConfig.RANDOM_MAX_VALUE.getValue());
            set.add(tmpNum);
        }

        return new Result(new ArrayList<>(set));
    }
}
