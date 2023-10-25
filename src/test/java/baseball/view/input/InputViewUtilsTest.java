package baseball.view.input;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class InputViewUtilsTest {

    @DisplayName("주어진 입력에서 모든 공백을 제거한 문자열을 반환한다")
    @ParameterizedTest
    @CsvSource(value = {"'\t a b c':abc", "'         ':''", "12 3:123", "'$ 1 ':$1"}, delimiter = ':')
    void trimmedString(String given, String expected) {
        assertThat(InputViewUtils.trimmedString(given)).isEqualTo(expected);
    }
}
