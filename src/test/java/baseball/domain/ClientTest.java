package baseball.domain;

import baseball.global.utils.generator.RandomNumberGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ClientTest {

	@DisplayName("increaseBallCount를 호출하면 ballCount가 증가된다.")
	@Test
	void should_increaseBallCount_when_invokeIncreaseBallCount() {
		Client client = new Client(new RandomNumberGenerator());

		client.increaseBallCount();
		Assertions.assertThat(client.getBallCount()).isEqualTo(1);
	}

	@DisplayName("increaseStrikeCount를 호출하면 strikeCount가 증가된다.")
	@Test
	void should_increaseStrikeCount_when_invokeIncreaseStrikeCount() {
		Client client = new Client(new RandomNumberGenerator());

		client.increaseStrikeCount();
		Assertions.assertThat(client.getStrikeCount()).isEqualTo(1);
	}

	@DisplayName("strikeCount = 0에서 gameEnd를 호출하면 true가 반환된다.")
	@Test
	void should_returnTrue_when_strikeCountIsThree() {
		Client client = new Client(new RandomNumberGenerator());

		for (int index = 0; index < 3; index++) {
			client.increaseStrikeCount();
		}
		Assertions.assertThat(client.gameEnd()).isTrue();
	}
}
