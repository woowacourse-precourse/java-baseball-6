package baseball;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Balls {

    private List<Ball> balls;

    public Balls(List<Integer> list) {
        if (list.size() != 3) {
            throw new IllegalArgumentException("숫자로 구성된 3자리 숫자를 입력해주세요.");
        }

        this.balls = makeBallList(list);
    }

    private List<Ball> makeBallList(List<Integer> list) {
        return IntStream.range(0, list.size())
                .mapToObj(i -> new Ball(list.get(i), (i + 1)))
                .collect(Collectors.toList());
    }

    public BallResultEnum play(Ball ball) {

        return balls.stream()
                .map(ball::play)
                .filter(ballResultEnum -> ballResultEnum != BallResultEnum.NOTHING)
                .findFirst()
                .orElse(BallResultEnum.NOTHING);
    }

    public PlayResult play(Balls userBalls) {

        PlayResult playResult = new PlayResult();

        balls.stream()
                .map(userBalls::play)
                .forEach(playResult::result);

        return playResult;
    }
}
