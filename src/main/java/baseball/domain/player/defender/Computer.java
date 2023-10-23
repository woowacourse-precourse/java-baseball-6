package baseball.domain.player.defender;

import baseball.domain.player.defender.value.Result;
import baseball.domain.player.defender.value.Results;
import baseball.domain.player.value.Ball;
import baseball.domain.player.value.Balls;
import baseball.exception.rutime.NotInitializeBallException;
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
	public Results compareBalls(Balls balls) {
		if (Objects.isNull(this.balls)) {
			throw new NotInitializeBallException();
		}
		List<Result> results = calcResults(balls);
		return new Results(results);
	}

	private List<Result> calcResults(Balls tgBalls) {
		List<Ball> filteredBalls = filter(tgBalls);

		return calculateResult(filteredBalls);
	}

	private List<Ball> filter(Balls target) {
		List<Ball> filtered = new ArrayList<>();
		for (int i = 0; i < target.size(); i++) {
			Ball ball = target.getBalls().get(i);
			if (balls.isContain(ball)) {
				filtered.add(ball);
			}
		}
		return filtered;
	}

	private List<Result> calculateResult(List<Ball> target) {
		List<Result> results = new ArrayList<>();
		int targetSize = target.size();
		for (int i = 0; i < targetSize; i++) {
			Ball ball = target.get(i);
			if (balls.isPosition(ball, (long) i)) {
				results.add(Result.STRIKE);
				continue;
			}
			results.add(Result.BALL);
		}
		return results;
	}
}