package baseball.domain.baseballnumber;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("[BaseballNumbersTest]")
class BaseballNumbersTest {

    @Test
    @DisplayName("정수 리스트로 생성 가능하다.")
    void construct() {
        // given
        List<Integer> inputs = Arrays.asList(1, 2, 3);

        // when
        BaseballNumbers baseballNumbers = new BaseballNumbers(inputs);

        // then
        assertThat(baseballNumbers.numbers().size()).isEqualTo(inputs.size());
    }

    @Test
    @DisplayName("입력된 값의 순서가 유지 되는지 확인")
    void maintainInputOrder() {
        // given
        List<Integer> inputs = Arrays.asList(1, 2, 3);

        // when
        BaseballNumbers baseballNumbers = new BaseballNumbers(inputs);

        // then
        List<BaseballNumber> numbers = baseballNumbers.numbers();
        int size = numbers.size();
        for (int i = 0; i < size; i++) {
            assertThat(numbers.get(i).value()).isEqualTo(inputs.get(i));
        }
    }

    @ParameterizedTest(name = "[{index}] : {0}")
    @MethodSource("invalidSizeNumbersData")
    @DisplayName("입력된 값이 3개가 아니라면 IllegalArgumentException을 발생한다.")
    void throwIllegalArgumentExceptionWhenInvalidSizeInput(List<Integer> numbers) {
        final String ERROR_MESSAGE_WRONG_SIZE = "세 개의 숫자를 입력해 주세요.";

        // when, then
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
            () -> new BaseballNumbers(numbers));
        assertThat(e.getMessage()).isEqualTo(ERROR_MESSAGE_WRONG_SIZE);
    }

    static Stream<Arguments> invalidSizeNumbersData() {
        return Stream.of(Arguments.of(Arrays.asList(1, 2, 3, 4)),
            Arguments.of(Arrays.asList(1, 2)));
    }

    @Test
    @DisplayName("중복값이 있다면 IllegalArgumentException을 발생한다.")
    void throwIllegalArgumentExceptionWhenDuplicatedInput() {
        // given
        final String ERROR_MESSAGE_DUPLICATED = "중복 없이 입력해 주세요.";
        List<Integer> input = Arrays.asList(1, 1, 2);

        // when, then
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
            () -> new BaseballNumbers(input));
        assertThat(e.getMessage()).isEqualTo(ERROR_MESSAGE_DUPLICATED);
    }

    @Test
    @DisplayName("입력값 중이 1-9 사이 값이 아닌게 있다면 IllegalArgumentException을 발생한다.")
    void throwIllegalArgumentExceptionWhenInvalidRangeInput() {
        // given
        final String ERROR_MESSAGE_INVALID_RANGE = "1에서 9 사이의 수만 입력할 수 있습니다.";
        List<Integer> input = Arrays.asList(0, 10, 2);

        // when, then
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
            () -> new BaseballNumbers(input));
        assertThat(e.getMessage()).isEqualTo(ERROR_MESSAGE_INVALID_RANGE);
    }

    @Test
    @DisplayName("중복을 제거 하여도 크기가 3인 경우 IllegalArgumentException을 발생한다.")
    void throwIllegalArgumentExceptionWhenSizeIsThreeAfterDeleteDuplicatedValue() {
        // given
        final String ERROR_MESSAGE_WRONG_SIZE = "세 개의 숫자를 입력해 주세요.";
        List<Integer> input = Arrays.asList(1, 1, 2, 3);

        // when, then
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,
            () -> new BaseballNumbers(input));
        assertThat(e.getMessage()).isEqualTo(ERROR_MESSAGE_WRONG_SIZE);
    }

    @Test
    @DisplayName("같은 값과 다른 순서의 BaseballNumber를 포함하고 있을 경우 containsWithDifferentIndex 메소드가 true를 반환한다.")
    void containsWithDifferentIndexReturnTrueWhenValueIsSameAndPositionIsDifferent() {
        // given
        int numberInput = 7;
        BaseballNumber baseballNumber = new BaseballNumber(numberInput);
        int index = 0;

        List<Integer> numbersInput = Arrays.asList(5, 7, 9);
        BaseballNumbers baseballNumbers = new BaseballNumbers(numbersInput);

        // when
        Boolean result = baseballNumbers.containsWithDifferentIndex(baseballNumber, index);

        // then
        assertThat(result).isEqualTo(true);
    }

    @Test
    @DisplayName("같은 위치와 같은 값의 BaseballNumber를 포함하고 있을 경우 containsWithSameIndex 메소드가 true를 반환한다.")
    void containsWithSameIndexReturnTrueWhenValueAndPositionAllSame() {
        // given
        int numberInput = 7;
        BaseballNumber baseballNumber = new BaseballNumber(numberInput);
        int index = 1;

        List<Integer> numbersInput = Arrays.asList(5, 7, 9);
        BaseballNumbers baseballNumbers = new BaseballNumbers(numbersInput);

        // when
        Boolean result = baseballNumbers.containsWithSameIndex(baseballNumber, index);

        // then
        assertThat(result).isEqualTo(true);
    }

    @Test
    @DisplayName("get 메소드가 올바른 인덱스의 BaseballNumber을 반환한다.")
    void getReturnValueOfIndex() {
        // given
        List<Integer> numbersInput = Arrays.asList(5, 7, 9);
        BaseballNumbers baseballNumbers = new BaseballNumbers(numbersInput);

        int numberInput = 7;
        BaseballNumber baseballNumber = new BaseballNumber(numberInput);
        int index = 1;

        // when
        BaseballNumber foundNumber = baseballNumbers.get(index);

        // then
        assertThat(foundNumber).isEqualTo(baseballNumber);
    }
}