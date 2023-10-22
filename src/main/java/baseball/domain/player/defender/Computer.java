package baseball.domain.player.defender;

import baseball.domain.player.defender.support.BallSource;
import baseball.domain.player.defender.value.Result;
import baseball.domain.player.defender.value.Results;
import baseball.domain.player.value.Ball;
import baseball.exception.rutime.NotInitializeBallException;
import baseball.support.converter.BallSourceConverter;
import baseball.support.filter.ExistBallFilter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Computer implements Defender {

	private List<Ball> balls;

	public Computer() {}

	@Override
	public void initialize(List<Ball> balls) {
		this.balls = balls;
	}

	@Override
	public Results compareBalls(List<Ball> balls) {
		if (Objects.isNull(this.balls)) {
			throw new NotInitializeBallException();
		}
		List<Result> results = calcResults(balls);
		return new Results(results);
	}

	private List<Result> calcResults(List<Ball> tgBalls) {
		List<Result> results = new ArrayList<>();
		BallSource source = BallSourceConverter.from(balls);
		BallSource target = BallSourceConverter.from(tgBalls);

		List<Ball> filteredTarget = ExistBallFilter.filter(balls, tgBalls);
		for (Ball ball : filteredTarget) {
			Result result = calcResult(source.getIndex(ball), target.getIndex(ball));
			results.add(result);
		}
		return results;
	}

	/** Index를 비교하여 스트라이크 여부 계산 */
	private Result calcResult(Integer sourceIndex, Integer targetIndex) {
		if (sourceIndex.equals(targetIndex)) {
			return Result.STRIKE;
		}
		return Result.BALL;
	}
}
