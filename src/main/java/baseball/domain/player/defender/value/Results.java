package baseball.domain.player.defender.value;

import java.util.List;

public class Results {

	private final List<Result> results;

	public Results(List<Result> results) {
		this.results = results;
	}

	public StrikeCount getStrikeCount() {
		long count = results.stream().filter(result -> result == Result.STRIKE).count();
		return new StrikeCount(count);
	}

	public BallCount getBallCount() {
		long count = results.stream().filter(result -> result == Result.BALL).count();

		return new BallCount(count);
	}
}
