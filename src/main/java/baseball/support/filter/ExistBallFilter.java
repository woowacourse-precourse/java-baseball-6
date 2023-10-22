package baseball.support.filter;

import baseball.domain.player.value.Ball;
import baseball.exception.state.UtilityClassConstructorException;
import java.util.List;
import java.util.stream.Collectors;

public class ExistBallFilter {

	private ExistBallFilter() {
		throw new UtilityClassConstructorException();
	}

	public static List<Ball> filter(List<Ball> source, List<Ball> target) {
		return target.stream().filter(source::contains).collect(Collectors.toList());
	}
}
