package baseball.domain.baseballplayer.team;

import baseball.domain.baseballplayer.dto.Ball;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class Computer implements BaseBallTeam {
    private final int NUMBER_SIZE = 3;
    private final int MIN_NUMBER = 1;
    private final int MAX_NUMBER = 9;
    private Ball ball;

    private Computer() {
    }

    public static Computer newInstance() {
        return new Computer();
    }

    @Override
    public Ball getBall() {
        return ball;
    }

    @Override
    public void createNewBall() {
        final List<Integer> randomNumbers =
                IntStream.generate(() -> Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER))
                        .distinct()
                        .limit(NUMBER_SIZE)
                        .boxed()
                        .collect(Collectors.toList());
        ball = new Ball(randomNumbers);
    }

}
