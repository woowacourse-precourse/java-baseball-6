package baseball.user;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class PlayerTest {

	@Test
	@DisplayName("플레이어는 임의의 숫자 3개를 뽑는다.")
	public void pickNumberTest() {
		//given
		Player player = new Player();
		String validNumber = "123";

		// when
		player.pickNumber(validNumber);

		//then
		assertEquals(validNumber, player.getNumber());
	}

	@ParameterizedTest
	@DisplayName("플레이어는 3개의 숫자 이외를 입력하면 IllegalArgumentException 발생한다.")
	@ValueSource(strings = { "1", "12", "1234", "12A" })
	public void pickNumberTest_false(String invalidNumber) {
		//given
		Player player = new Player();
		//when & then
		assertThrows(IllegalArgumentException.class, () ->
			player.pickNumber(invalidNumber)
		);
	}
}
