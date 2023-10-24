package baseball.support.filter;

import baseball.domain.player.value.Ball;
import baseball.domain.player.value.Balls;
import baseball.exception.state.UtilityClassConstructorException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ExistBallFilter {

	private ExistBallFilter() {
		throw new UtilityClassConstructorException();
	}

	public static List<Ball> filter(List<Ball> source, List<Ball> target) {
		return target.stream().filter(source::contains).collect(Collectors.toList());
	}

	public static Balls filter(Balls source, Balls target) {
		List<Ball> filteredBalls = new ArrayList<>();
		for (int i = 0; i < target.size(); i++) {
			Ball ball = target.getBall(i);
			if (source.isContain(ball)) {
				filteredBalls.add(ball);
			}
		}
		return new Balls(filteredBalls);
	}
}
