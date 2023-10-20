package baseball.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import baseball.util.message.ErrorMessage;

public class BaseballNumberTest {

	@DisplayName("중복된 숫자가 있는 지 확인한다.")
	@Test
	void checkDuplicatedNumber() {
		assertThatThrownBy(() -> new BaseballNumber(List.of(1, 1, 2)))
			.isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining(ErrorMessage.NUMBER_DUPLICATE_ERROR.getMessage());

	}
	
	@DisplayName("중복된 숫자가 없을 때 정삭적으로 작동하는 지 확인한다.")
	@Test
	void checkNomalOperation1() {
		new BaseballNumber(List.of(1, 3, 2));
	}

	@DisplayName("List의 길이가 3인지를 확인한다.")
	@Test
	void checkOutofLength() {
		assertThatThrownBy(() -> new BaseballNumber(List.of(1, 2)))
			.isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining(ErrorMessage.DIGIT_LENGTH_ERROR.getMessage());

	}
	
	@DisplayName("List의 길이가 3일떄 정상적으로 작동하는 지 확인한다.")
	@Test
	void checkNomalOperation2() {
		new BaseballNumber(List.of(1, 3, 2));
	}
}
