package baseball.support.converter;

import baseball.domain.player.defender.support.BallSource;
import baseball.domain.player.value.Ball;
import baseball.exception.state.UtilityClassConstructorException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BallSourceConverter {

	private BallSourceConverter() {
		throw new UtilityClassConstructorException();
	}

	public static BallSource from(List<Ball> source) {
		Map<Ball, Integer> converted = new HashMap<>();
		for (int i = 0; i < source.size(); i++) {
			converted.put(source.get(i), i);
		}
		return new BallSource(converted);
	}
}
