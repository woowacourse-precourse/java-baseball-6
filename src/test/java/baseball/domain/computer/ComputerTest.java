package baseball.domain.computer;

import static org.assertj.core.api.Assertions.*;

import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ComputerTest {

	@Test
	@DisplayName("게임이 시작되면 컴퓨터는 세 자릿수의 숫자를 생성한다.")
	void computerCreate() {
	    //given
		final int numbersSize = 3;
		final Computer computer = ComputerFactory.getInstance(numbersSize);

		//when
		final Map<Integer, Integer> numbers = computer.numbers();

		//expected
		final int expectedSize = numbers.size();
		assertThat(numbersSize).isEqualTo(expectedSize);
	}
}
