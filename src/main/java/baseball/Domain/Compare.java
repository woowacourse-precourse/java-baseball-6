package baseball.Domain;

import baseball.Dto.RandomNumbers;
import baseball.Dto.Result;
import baseball.Dto.UserNumbers;

import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class Compare {
    private final RandomNumbers randomNumbers;
    private final UserNumbers userNumbers;

    public Compare() {
        this.randomNumbers = RandomNumbers.getInstance();
        this.userNumbers = UserNumbers.getInstance();
    }
    public void compareNumbers() {
        saveResult(strike(), ball());
    }

    private int strike() {
        List<Integer> computer = randomNumbers.requestRandomNumbers();
        List<Integer> user = userNumbers.requestUserNumbers();
        return (int) IntStream.range(0, computer.size())
                .filter(i -> Objects.equals(computer.get(i), user.get(i)))
                .count();
    }

    private int ball() {
        List<Integer> computer = randomNumbers.requestRandomNumbers();
        List<Integer> user = userNumbers.requestUserNumbers();
        return (int) IntStream.range(0, computer.size())
                .filter(i -> user.contains(computer.get(i)))
                .count();
    }

    private void saveResult(int strike, int ball) {
        Result result = Result.getInstance();
        result.createResult(strike, ball - strike);
    }
}
