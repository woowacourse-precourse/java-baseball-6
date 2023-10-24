package baseball;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import baseball.domain.Numbers;
import baseball.domain.Referee;

public class RefereeTest {
	@Test
	void 심판은_스트라이크_개수를_셀_수_있다() {
		Referee referee = new Referee(List.of(1,2,7));
		List<Integer> inputNumbers = List.of(1,2,3);
		Numbers playerNumbers = new Numbers(inputNumbers);

		Assertions.assertThat(referee.countStrike(playerNumbers)).isEqualTo(2);
	}
}
