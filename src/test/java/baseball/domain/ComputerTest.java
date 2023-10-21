package baseball.domain;

import static org.assertj.core.api.Assertions.assertThatNoException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ComputerTest {

	@Test
	@DisplayName("컴퓨터의 Balls 생성")
	void whenCreateComputer_thenNoException() {
		assertThatNoException()
			.isThrownBy(Computer::new);
	}

}
