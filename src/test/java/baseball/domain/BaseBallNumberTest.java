package baseball.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BaseBallNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 10})
    void 야구_숫자_범위에_벗어난_경우에는_객체_생성에_실패한다(int baseballNumber) {
        assertThatThrownBy(() -> BaseBallNumber.from(baseballNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("야구 숫자 범위에 맞는 값은 객체 생성에 성공한다")
    @ParameterizedTest
    @ValueSource(ints = {1, 9})
    void 야구_숫자_범위에_맞는_값은_객체_생성에_성공한다(int baseballNumber) {
        assertDoesNotThrow(() -> BaseBallNumber.from(baseballNumber));
    }

}
