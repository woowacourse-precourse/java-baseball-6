package baseball.domain.player.defender;

import baseball.domain.player.defender.value.Result;
import baseball.domain.player.defender.value.Results;
import baseball.domain.player.value.Ball;
import baseball.domain.player.value.Balls;
import baseball.exception.rutime.NotInitializeBallException;
import baseball.support.filter.ExistBallFilter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Computer implements Defender {

	private Balls balls;

	public Computer() {}

	@Override
	public void initialize(Balls balls) {
		this.balls = balls;
	}

	@Override
	public Results defend(Balls balls) {
		if (Objects.isNull(this.balls)) {
			throw new NotInitializeBallException();
		}
		List<Result> results = calcResults(balls);
		return new Results(results);
	}

	private List<Result> calcResults(Balls tgBalls) {
		Balls filteredBalls = filter(tgBalls);

		return calculateResult(filteredBalls);
	}

	private Balls filter(Balls target) {
		return ExistBallFilter.filter(balls, target);
	}

	private List<Result> calculateResult(Balls target) {
		List<Result> results = new ArrayList<>();
		Long targetSize = target.size();
		for (int i = 0; i < targetSize; i++) {
			Ball ball = target.getBall(i);
			results.add(getResult(ball, (long) i));
		}
		return results;
	}

	private Result getResult(Ball ball, Long idx) {
		if (balls.isSame(ball, idx)) {
			return Result.STRIKE;
		}
		return Result.BALL;
	}
}