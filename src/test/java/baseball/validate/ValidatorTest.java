package baseball.validate;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import baseball.util.message.ErrorMessage;
import baseball.util.validate.Validator;

public class ValidatorTest {

	@DisplayName("0과 문자를 제외한 숫자형식인지를 확인한다.")
	@ValueSource(strings = { "#", "012" })
	@ParameterizedTest
	void checkNumberFormat(String str) {
		assertThatThrownBy(() -> Validator.validateNumberFormat(str))
			.isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining(ErrorMessage.INPUT_LETTER_ERROR.getMessage());
	}

	@DisplayName("0을 제외한 숫자를 입력했을 때의 정상적으로 작동하는 지 확인한다.")
	@ValueSource(strings = { "123", "456" })
	@ParameterizedTest
	void checkNomalOperation1(String str) {
		Validator.validateNumberFormat(str);
	}

	@DisplayName("Continue객체의 올바른 command값인지 확인한다.")
	@ValueSource(strings = { "3", "4" })
	@ParameterizedTest
	void checkContinueCommand(String str) {
		assertThatThrownBy(() -> Validator.validateContinueCommand(str))
			.isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining(ErrorMessage.COMMAND_ERROR.getMessage());
	}

	@DisplayName("올바른 command값일 떄 정상적으로 작동하는 지 확인한다.")
	@ValueSource(strings = { "1", "2" })
	@ParameterizedTest
	void checkNomalOperation2(String str) {
		Validator.validateContinueCommand(str);
	}

	@DisplayName("문자의 길이가 3인지를 확인한다.")
	@ValueSource(strings = { "as", "1234" })
	@ParameterizedTest
	void checㅏOutOfLength(String str) {
		assertThatThrownBy(() -> Validator.validateOutOfLength(str))
		    .isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining(ErrorMessage.DIGIT_LENGTH_ERROR.getMessage());
	}

	@DisplayName("문자의 길이가 3일 때 정상적으로 작동하는 지 확인한다.")
	@ValueSource(strings = { "123", "ads" })
	@ParameterizedTest
	void checkNomalOperation3(String str) {
		Validator.validateOutOfLength(str);
	}

	@DisplayName("중복된 숫자가 있는 지 확인한다.")
	@ValueSource(strings = { "121", "344" })
	@ParameterizedTest
	void checkDuplicatedNumber(String str) {
		assertThatThrownBy(() -> Validator.validateDuplicatedNumber(str))
			.isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining(ErrorMessage.NUMBER_DUPLICATE_ERROR.getMessage());
	}

	@DisplayName("중복된 숫자가 없을 때 정삭적으로 작동하는 지 확인한다.")
	@ValueSource(strings = { "123", "456" })
	@ParameterizedTest
	void checkNomalOperation4(String str) {
		Validator.validateDuplicatedNumber(str);
	}
}
