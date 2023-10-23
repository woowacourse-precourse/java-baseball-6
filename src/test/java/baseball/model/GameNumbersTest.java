package baseball.model;

import static baseball.model.message.ErrorMessage.DUPLICATED_NUMBER;
import static baseball.model.message.ErrorMessage.INVALID_NUMBERS_LENGTH;
import static baseball.model.message.ErrorMessage.INVALID_RANGE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class GameNumbersTest {

    @Nested
    @DisplayName("숫자 자리수 테스트")
    class NumbersSizeTest {

        @Test
        @DisplayName("세 자리수일 경우 생성된다.")
        public void 세_자리수일_경우_생성된다() {
            //given
            List<Integer> numbers = List.of(1, 2, 3);

            //when
            GameNumbers gameNumbers = new GameNumbers(numbers);

            //then
            assertThat(gameNumbers.getNumbers()).containsAll(numbers);
        }

        @ParameterizedTest
        @ValueSource(ints = {0, 1, 2, 4, 5, 6, 7, 8, 9, 10})
        @DisplayName("유효하지 않은 자리수일 경우 IllegalArgumentException 발생한다.")
        public void 유효하지_않은_자리수일_경우_IllegalArgumentException_발생한다(int invalidSize) {
            //given
            List<Integer> numbers = new ArrayList<>();
            for (int i = 0; i < invalidSize; i++) {
                numbers.add(i);
            }

            //when & then
            IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
                new GameNumbers(numbers);
            });

            assertThat(exception).hasMessage(INVALID_NUMBERS_LENGTH.getMessage());
        }
    }

    @Nested
    @DisplayName("숫자 범위 테스트")
    class NumberRangeTest {

        @Test
        @DisplayName("숫자가 1 이상, 9 이하일 경우 생성된다.")
        public void 숫자가_1_이상_9_이하일_경우_생성된다() {
            //given
            List<Integer> numbers = List.of(1, 2, 3);

            //when
            GameNumbers gameNumbers = new GameNumbers(numbers);

            //then
            assertThat(gameNumbers.getNumbers()).containsAll(numbers);
        }

        @Test
        @DisplayName("숫자가 1 미만, 9 초과일 경우 IllegalArgumentException 발생한다.")
        public void 숫자가_1_미만_9_초과일_경우_IllegalArgumentException_발생한다() {
            //given
            List<Integer> includeZeroList = List.of(0, 2, 3);
            List<Integer> includeTenList = List.of(10, 2, 3);

            //when & then
            IllegalArgumentException includeZeroException = assertThrows(IllegalArgumentException.class, () -> {
                new GameNumbers(includeZeroList);
            });
            IllegalArgumentException includeTenException = assertThrows(IllegalArgumentException.class, () -> {
                new GameNumbers(includeTenList);
            });

            assertThat(includeZeroException).hasMessage(INVALID_RANGE.getMessage());
            assertThat(includeTenException).hasMessage(INVALID_RANGE.getMessage());
        }
    }

    @Test
    @DisplayName("중복 숫자가 있을 경우 IllegalArgumentException 발생한다.")
    public void 중복_숫자가_있을_경우_IllegalArgumentException_발생한다() {
        //given
        List<Integer> twoDuplicateNumbers = List.of(1, 1, 2);
        List<Integer> threeDuplicateNumbers = List.of(1, 1, 1);

        //when & then
        IllegalArgumentException twoDuplicateException = assertThrows(IllegalArgumentException.class, () -> {
            new GameNumbers(twoDuplicateNumbers);
        });
        IllegalArgumentException threeDuplicateException = assertThrows(IllegalArgumentException.class, () -> {
            new GameNumbers(threeDuplicateNumbers);
        });

        assertThat(twoDuplicateException).hasMessage(DUPLICATED_NUMBER.getMessage());
        assertThat(threeDuplicateException).hasMessage(DUPLICATED_NUMBER.getMessage());
    }
}
