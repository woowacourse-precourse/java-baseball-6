package baseball.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BaseBallNumberTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 10})
    void 야구_숫자_범위에_벗어난_경우에는_야구_숫자_생성에_실패한다(int baseballNumber) {
        assertThatThrownBy(() -> BaseBallNumber.from(baseballNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 9})
    void 야구_숫자_범위에_맞는_값은_야구_숫자_생성에_성공한다(int baseballNumber) {
        assertDoesNotThrow(() -> BaseBallNumber.from(baseballNumber));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 10})
    void 랜덤한_숫자가_들어올_때_야구_숫자_범위에_벗어나는_경우는_야구_숫자_생성에_실패한다(int randomNumber) {
        NumberGenerator randomGenerator = (min, max) -> randomNumber;

        assertThatThrownBy(() -> BaseBallNumber.createRandomNumber(randomGenerator))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 9})
    void 랜덤한_숫자가_들어올_때_야구_숫자_범위에_맞는_경우는_야구_숫자_생성에_성공한다(int randomNumber) {
        NumberGenerator randomGenerator = (min, max) -> randomNumber;

        assertDoesNotThrow(() -> BaseBallNumber.createRandomNumber(randomGenerator));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 9})
    void 야구_숫자가_같다면_같은_객체로_판단한다(int number) {
        BaseBallNumber baseBallNumber = BaseBallNumber.from(number);
        BaseBallNumber expectedBaseBallNumber = BaseBallNumber.from(number);

        assertThat(baseBallNumber).isEqualTo(expectedBaseBallNumber);
    }

}
