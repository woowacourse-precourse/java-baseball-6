package baseball.model;

import static baseball.Constants.NUMBER_COUNTS;
import static baseball.fixture.UserNumbersFixture.createUserNumbersByString;
import static org.junit.jupiter.api.Assertions.*;

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
            .range(FIRST_NUM, NUMBER_COUNTS + PLUS_NUMBER_FOR_END_EXCLUSIVE)
            .forEach(numberString::append);

        // when & then
        assertThrows(IllegalArgumentException.class, () ->
            createUserNumbersByString(numberString.toString()));
    }

    @Test
    @DisplayName("중복된 숫자들이 입력으로 들어올 경우 예외 처리")
    void when_() {
        // given
        String duplicatedNumbers = "1".repeat(NUMBER_COUNTS);

        // when & then
        assertThrows(IllegalArgumentException.class, () ->
            createUserNumbersByString(duplicatedNumbers));
    }
}
