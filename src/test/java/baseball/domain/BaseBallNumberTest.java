package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BaseBallNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 10})
    void 야구_숫자_범위에_벗어난_경우에는_객체_생성에_실패한다(int baseballNumber) {
        assertThatThrownBy(() -> BaseBallNumber.generateNumber(baseballNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("야구 숫자 범위에 맞는 값은 객체 생성에 성공한다")
    @ParameterizedTest
    @ValueSource(ints = {1, 9})
    void 야구_숫자_범위에_맞는_값은_객체_생성에_성공한다(int baseballNumber) {
        assertDoesNotThrow(() -> BaseBallNumber.generateNumber(baseballNumber));
    }

    @DisplayName("랜덤한 숫자가 들어올 때 야구 숫자 범위에 벗어나는 경우는 객체 생성에 실패한다")
    @ParameterizedTest
    @ValueSource(ints = {0, 10})
    void 랜덤한_숫자가_들어올_때_야구_숫자_범위에_벗어나는_경우는_객체_생성에_실패한다(int randomNumber) {
        NumberGenerator randomGenerator = (min, max) -> randomNumber;

        assertThatThrownBy(() -> BaseBallNumber.generateRandomNumber(randomGenerator))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("랜덤한 숫자가 들어올 때 야구 숫자 범위에 맞는 경우는 객체 생성에 성공한다")
    @ParameterizedTest
    @ValueSource(ints = {1, 9})
    void 랜덤한_숫자가_들어올_때_야구_숫자_범위에_맞는_경우는_객체_생성에_성공한다(int randomNumber) {
        NumberGenerator randomGenerator = (min, max) -> randomNumber;

        assertDoesNotThrow(() -> BaseBallNumber.generateRandomNumber(randomGenerator));
    }

    @DisplayName("야구 숫자가 같다면 같은 객체로 판단한다")
    @ParameterizedTest
    @ValueSource(ints = {1, 9})
    void 야구_숫자가_같다면_같은_객체로_판단한다(int number) {
        BaseBallNumber baseBallNumber = BaseBallNumber.generateNumber(number);
        BaseBallNumber expectedBaseBallNumber = BaseBallNumber.generateNumber(number);

        assertThat(baseBallNumber).isEqualTo(expectedBaseBallNumber);
    }

}
