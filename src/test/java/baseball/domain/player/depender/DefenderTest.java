package baseball.domain.player.depender;

import static org.junit.jupiter.api.Assertions.*;

import baseball.domain.player.defender.Computer;
import baseball.domain.player.defender.Defender;
import baseball.domain.player.defender.value.BallCount;
import baseball.domain.player.defender.value.Results;
import baseball.domain.player.defender.value.StrikeCount;
import baseball.domain.player.value.Ball;
import baseball.domain.player.value.Balls;
import baseball.exception.rutime.NotInitializeBallException;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class DefenderTest {

	private final Balls RESULT_BALLS =
		new Balls(List.of(Ball.of(1L), Ball.of(2L), Ball.of(3L)));

	@Test
	@DisplayName("방어자의 공을 초기화하지 않으면 예외가 발생한다.")
	void needInitialize() {
		// given
		Defender defender = new Computer();

		// when

		// then
		assertThrows(NotInitializeBallException.class, () -> defender.defend(RESULT_BALLS));
	}

	@DisplayName("방어자가 숫자를 비교한다.")
	@ParameterizedTest
	@CsvSource(
			value = {
				"1:2:3:3:0", // 3 strike
				"1:2:4:2:0", // 2 strike
				"1:4:5:1:0", // 1 strike
				"3:1:2:0:3", // 3 ball
				"4:1:2:0:2", // 2 ball
				"4:5:1:0:1", // 1 ball
				"4:5:6:0:0", // noting
			},
			delimiter = ':')
	void compareNumbers(long n1, long n2, long n3, long strikeCount, long ballCount) {
		// given
		List<Long> numbers = List.of(n1, n2, n3);
		List<Ball> balls = numbers.stream().map(Ball::of).collect(Collectors.toList());
		Defender defender = new Computer();
		defender.initialize(new Balls(balls));

		// when
		Results results = defender.defend(RESULT_BALLS);

		// then
		assertEquals(new StrikeCount(strikeCount), results.getStrikeCount());
		assertEquals(new BallCount(ballCount), results.getBallCount());
	}
}
