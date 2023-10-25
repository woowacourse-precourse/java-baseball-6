package baseball.model;

import static baseball.ErrorMessage.DUPLICATED_NUMBER;
import static baseball.ErrorMessage.INVALID_SIZE;
import static baseball.ErrorMessage.NOT_NUMBER;
import static baseball.NumericRange.COUNT;
import static baseball.fixture.UserNumbersFixture.createUserNumbersByString;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.stream.IntStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserNumbersTest {

    private static final int FIRST_NUM = 1;
    private static final int PLUS_NUMBER_FOR_END_EXCLUSIVE = 2;


    @Test
    @DisplayName("추측 입력이 지정된 숫자 길이보다 클 경우 예외 처리")
    void when_guess_number_size_is_larger_than_num_count_throw_exception() {
        // given
        StringBuilder numberString = new StringBuilder();
        IntStream
            .range(FIRST_NUM, COUNT.getNumber() + PLUS_NUMBER_FOR_END_EXCLUSIVE)
            .forEach(numberString::append);

        // when & then
        assertAll(() -> {
            Throwable exception = assertThrows(IllegalArgumentException.class, () ->
                createUserNumbersByString(numberString.toString()));
            assertEquals(INVALID_SIZE.getMessage(), exception.getMessage());
        });
    }

    @Test
    @DisplayName("중복된 숫자들이 입력으로 들어올 경우 예외 처리")
    void when_duplicated_number_throw_exception() {
        // given
        String duplicatedNumbers = "1".repeat(COUNT.getNumber());

        // when & then
        assertAll(() -> {
            Throwable exception = assertThrows(IllegalArgumentException.class, () ->
                createUserNumbersByString(duplicatedNumbers));
            assertEquals(DUPLICATED_NUMBER.getMessage(), exception.getMessage());
        });
    }

    @Test
    @DisplayName("숫자가 아닌 문자가 입력으로 들어올 경우 예외 처리")
    void when_non_numeric_characters_throw_exception() {
        // given
        String nonNumericCharacters = "nonNumeric";

        // when & then
        assertAll(() -> {
            Throwable exception = assertThrows(IllegalArgumentException.class, () ->
                createUserNumbersByString(nonNumericCharacters));
            assertEquals(NOT_NUMBER.getMessage(), exception.getMessage());
        });
    }
}
