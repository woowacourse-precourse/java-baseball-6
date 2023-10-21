package baseball.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

class BaseballRefereeTest {

	@Test
	void compare_메서드는_컴퓨터와_플레이어의_숫자가_주어지면_볼과_스트라이크_갯수를_계산한다() {
		BaseballReferee baseballReferee = new BaseballReferee();
		BaseballNumber computerNumbers = new BaseballNumber(List.of(1, 2, 3));
		BaseballNumber playerNumbers = new BaseballNumber(List.of(1, 2, 3));

		Hint hint = baseballReferee.compare(computerNumbers, playerNumbers);

		assertEquals(3, hint.getStrikeCount());
		assertEquals(0, hint.getBallCount());
	}
}
