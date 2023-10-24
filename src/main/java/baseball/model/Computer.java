package baseball.model;

import baseball.constant.GameResult;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Computer {
    private final Numbers numbers;

    public Computer(List<Integer> numbers) {
        this.numbers = new Numbers(numbers);
    }

    public static List<Integer> createNumbers() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!numbers.contains(randomNumber)) {
                numbers.add(randomNumber);
            }
        }
        return numbers;
    }

    public Map<GameResult, Long> compare(Numbers userNumbers) {
        long totalCount = numbers.countContains(userNumbers);
        long strikeCount = numbers.countMatching(userNumbers);
        long ballCount = Math.abs(strikeCount - totalCount);
        if (strikeCount == 0 && ballCount == 0) {
            return Map.of(GameResult.NOTHING, totalCount);
        }
        return Map.of(GameResult.STRIKE, strikeCount, GameResult.BALL, ballCount);

    }
}
