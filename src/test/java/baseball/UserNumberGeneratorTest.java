package baseball;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class UserNumberGeneratorTest {

    @DisplayName("잘못된 숫자를 입력하였을 때, 정확한 예외 메시지를 출력하는지 확인합니다.")
    @ParameterizedTest
    @CsvSource(value = {
            " /입력값이 존재하지 않습니다.",
            "190/0은 입력할 수 없습니다.",
            "2-13/음수값은 입력할 수 없습니다.",
            "4/입력되는 숫자는 3자리여야 합니다.",
            "19/입력되는 숫자는 3자리여야 합니다.",
            "2819/입력되는 숫자는 3자리여야 합니다.",
            "121/중복된 숫자는 입력할 수 없습니다."}, delimiter = '/')
    void generate_withInvalidInput_ThrowsException(String input, String expectedMessage) {
        UserNumberGenerator numberGenerator = new UserNumberGenerator();
        assertThatThrownBy(() -> numberGenerator.generate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(expectedMessage);
    }
}