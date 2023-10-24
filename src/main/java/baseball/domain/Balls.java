package baseball.domain;


import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Balls {

    private final List<Ball> balls;

    private Balls(List<Integer> numbers) {
        validate(numbers);
        this.balls = mapToBalls(numbers);
    }

    public static Balls of(List<Integer> numbers) {
        return new Balls(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (new HashSet<>(numbers).size() != numbers.size()) {
            throw new IllegalArgumentException("중복된 숫자가 있습니다.");
        }
        if (numbers.size() != 3) {
            throw new IllegalArgumentException("숫자는 3개만 가능합니다.");
        }
    }

    private List<Ball> mapToBalls(List<Integer> randomNumbers) {
        return randomNumbers.stream()
                .map(number -> Ball.of(number, randomNumbers.indexOf(number) + 1))
                .collect(Collectors.toList());
    }

    public RoundResult compareWith(Balls answer) {
        RoundResult playResult = new RoundResult();
        balls.forEach(ball -> answer.balls.stream().map(ball::match).forEach(playResult::add));
        return playResult;
    }
}