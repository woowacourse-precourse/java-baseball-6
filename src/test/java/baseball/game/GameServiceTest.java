package baseball.game;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class GameServiceTest {

	private final GameService gameService = new GameService();

	@Test
	void countBall() {
		List<Integer> user = List.of(1, 2, 3);
		List<Integer> answer = List.of(7, 8, 2);

		int balls = gameService.countBall(user, answer);

		assertThat(balls).isEqualTo(1);
	}

	@Test
	void countStrike() {
		List<Integer> user = List.of(1, 2, 3);
		List<Integer> answer = List.of(1, 2, 4);

		int balls = gameService.countStrike(user, answer);

		assertThat(balls).isEqualTo(2);
	}

	@Test
	void giveHint_TowBalls() {
		List<Integer> user = List.of(1, 2, 3);
		List<Integer> answer = List.of(3, 4, 1);

		String hint = gameService.giveHint(user, answer);

		assertThat(hint).isEqualTo("2볼");
	}

	@Test
	void giveHint_TowStrikes() {
		List<Integer> user = List.of(1, 2, 3);
		List<Integer> answer = List.of(1, 2, 4);

		String hint = gameService.giveHint(user, answer);

		assertThat(hint).isEqualTo("2스트라이크");
	}

	@Test
	void giveHint_OneBall_OneStrike() {
		List<Integer> user = List.of(1, 2, 3);
		List<Integer> answer = List.of(1, 7, 2);

		String hint = gameService.giveHint(user, answer);

		assertThat(hint).isEqualTo("1볼 1스트라이크");
	}
}