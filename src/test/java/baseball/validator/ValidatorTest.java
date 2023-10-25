package baseball.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("validator 검증")
class ValidatorTest {

    Validator validator = new Validator();

    static Stream<Arguments> getUniqueNumbers() {
        return Stream.of(Arguments.of(List.of(1, 2, 3))
                , Arguments.of(List.of(4, 5, 6))
                , Arguments.of(List.of(7, 8, 9))
                , Arguments.of(List.of(1, 5, 8))
                , Arguments.of(List.of(3, 2, 1))
                , Arguments.of(List.of(3, 2, 1, 10))
                , Arguments.of(List.of(3))
                , Arguments.of(List.of(1, 2))
                , Arguments.of(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 0))
        );
    }

    static Stream<Arguments> getDuplicateNumbers() {
        return Stream.of(Arguments.of(List.of(1, 2, 1))
                , Arguments.of(List.of(4, 5, 4))
                , Arguments.of(List.of(7, 8, 8))
                , Arguments.of(List.of(8, 5, 8))
                , Arguments.of(List.of(1, 2, 1))
                , Arguments.of(List.of(3, 2, 3, 2))
                , Arguments.of(List.of(1, 1, 1, 1))
                , Arguments.of(List.of(1, 2, 1, 2))
                , Arguments.of(List.of(1, 2, 3, 4, 5, 6, 7, 7, 8, 9, 0))
        );
    }

    @DisplayName("null, 공백이 아닌 문자열을 입력하면 성공한다.")
    @ParameterizedTest(name = "[{index}차]시도: value: {0}, {1}")
    @ValueSource(strings = {"12", "english", "한글", "aaaa", "1a"})
    void testVerifyNullAndEmpty(String str) {
        //given
        //when
        validator.verifyNullAndEmpty(str);
        //then
    }

    @DisplayName("null, 공백 으로 이루어진 문자열을 입력하면 IllegalArgumentException 이 발생한다..")
    @ParameterizedTest(name = "[{index}차]시도: value: {0}")
    @NullAndEmptySource
    void failVerifyForBaseballNumber(String str) {
        //given
        //when
        //then
        assertThatThrownBy(() -> validator.verifyNullAndEmpty(str));
    }

    @DisplayName("제한된 범위 안에 숫자이면 성공한다.")
    @ParameterizedTest(name = "[{index}차]시도: value: {0}")
    @ValueSource(ints = {1, 2})
    void testVerifyInRangeClosed(int value) {
        //given
        //when
        validator.verifyInRangeClosed(1, 2, value);
        //then
    }

    @DisplayName("제한된 범위에 속하지 않으면 IllegalArgumentException 발생한다.")
    @ParameterizedTest(name = "[{index}차]시도: value: {0}")
    @ValueSource(ints = {0, 3, 5, 100, 1000})
    void failVerifyInRangeClosed(int value) {
        // given
        // when
        // then
        assertThatThrownBy(() -> validator.verifyInRangeClosed(1, 2, value))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("고유한 숫자이면 성공한다.")
    @ParameterizedTest(name = "[{index}차]시도: input: {0}")
    @MethodSource("getUniqueNumbers")
    void testVerifyUniqueNumber(List<Integer> uniqueNumbers) {
        // given
        // when
        validator.verifyUniqueNumber(uniqueNumbers);
        // then
    }

    @DisplayName("고유한 숫자가 아니면 IllegalArgumentException 발생한다.")
    @ParameterizedTest(name = "[{index}차]시도: input: {0}")
    @MethodSource("getDuplicateNumbers")
    void failVerifyDuplicateNumber(List<Integer> duplicateNumbers) {
        // given
        // when
        // then
        assertThatThrownBy(() -> validator.verifyUniqueNumber(duplicateNumbers));
    }

    @DisplayName("문자열 한 문자들이 숫자이면 성공한다.")
    @ParameterizedTest(name = "[{index}차]시도: input: {0}")
    @ValueSource(strings = {"1", "12", "1234", "111", "333", "777", "6"})
    void testVerifyNumberPerUnit(String input) {
        // given
        // when
        validator.verifyNumberPerUnit(input);
        // then
    }

    @DisplayName("문자열 한 문자들이 모두 숫자가 아니면 IllegalArgumentException 발생한다.")
    @ParameterizedTest(name = "[{index}차]시도: input: {0}")
    @ValueSource(strings = {"1a", "12아", "english", "java", "333go", "77ii7", "ililiii"})
    void failVerifyNumberPerUnit(String input) {
        // given
        // when
        // then
        assertThatThrownBy(() -> validator.verifyNumberPerUnit(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("입력한 제한된 길이와 같으면 성공한다.")
    @ParameterizedTest(name = "[{index}차]시도: input: {0}")
    @ValueSource(strings = {"1a", "12아", "english", "java", "333go", "77ii7", "ililiii"})
    void testVerifyLength(String input) {
        // given
        // when
        validator.verifyLength(input, input.length());
        // then
    }

    @DisplayName("입력한 제한된 길이와 같지 않으면 illegalArgumentException 발생한다.")
    @ParameterizedTest(name = "[{index}차]시도: input: {0}")
    @ValueSource(strings = {"1a", "12아", "english", "java", "333go", "77ii7", "ililiii"})
    void failVerifyLength(String input) {
        // given
        // when
        // then
        assertThatThrownBy(() -> validator.verifyLength(input, input.length() - 1))
                .isInstanceOf(IllegalArgumentException.class);
    }
}